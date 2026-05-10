package app;

import java.util.ArrayList;

import dados.*;

public class ACMESpiele {
    private GerenciadorIOArquivos IO = new GerenciadorIOArquivos("datain.txt", "dataout.txt");;
    private Clientes clientes = new Clientes();
    private Jogos jogos = new Jogos();
    private Contratos contratos = new Contratos();

    public ACMESpiele() {
        IO.redirecionaEntrada();
        IO.redirecionaSaida();
    }

    public void executar() {
        Cliente cliente;
        Jogo jogo;
        Contrato contrato;
        /**
         * Loop 1: cadastro de clientes individuais
         */
        while (true) {
            int numero = Integer.parseInt(IO.getEntrada());
            if (numero == -1) break;
            String nome = IO.getEntrada();
            String email = IO.getEntrada();
            String cpf = IO.getEntrada();

            cliente = new ClienteIndividual(numero, nome, email, cpf);

            if (clientes.adicionar(cliente)) {
                System.out.println(cliente.descrever());
            } else { System.out.println("1:erro-numero repetido."); }
        }

        /**
         * Loop 2: cadastro de clientes corporativos
         */
        while (true) {
            int numero = Integer.parseInt(IO.getEntrada());
            if (numero == -1) break;
            String nome = IO.getEntrada();
            String email = IO.getEntrada();
            String cnpj = IO.getEntrada();
            String nomeFantasia = IO.getEntrada();

            cliente = new ClienteCorporativo(numero, nome, email, cnpj, nomeFantasia);

            if (clientes.adicionar(cliente)) {
                System.out.println(cliente.descrever());
            } else { System.out.println("2:erro-numero repetido."); }
        }

        /**
         * Loop 3: cadastro de jogos
         */
        while (true) {
            int codigo = Integer.parseInt(IO.getEntrada());
            if (codigo == -1) break;
            String nome = IO.getEntrada();
            int ano = Integer.parseInt(IO.getEntrada());
            double valorMinuto = Double.parseDouble(IO.getEntrada());
            Categoria categoria;

            try {
                categoria = Categoria.valueOf(IO.getEntrada());
            } catch (IllegalArgumentException e) {
                System.out.println("3:erro-categoria inexistente.");
                continue;
            }

            jogo = new Jogo(codigo, nome, ano, valorMinuto, categoria);

            if (jogos.adicionar(jogo)) {
                System.out.println(jogo.descrever());
            } else { System.out.println("3:erro-codigo repetido."); }
        }

        /**
         * Loop 4: cadastro de contratos
         */
        while (true) {
            int id = Integer.parseInt(IO.getEntrada());
            if (id == -1) break;
            int periodo = Integer.parseInt(IO.getEntrada());
            int numeroCliente = Integer.parseInt(IO.getEntrada());
            int codigoJogo = Integer.parseInt(IO.getEntrada());

            cliente = clientes.buscar(numeroCliente);
            if (cliente == null) {
                System.out.println("4:erro-cliente inexistente.");
                continue;
            }
            jogo = jogos.buscar(codigoJogo);
            if (jogo == null) {
                System.out.println("4:erro-jogo inexistente.");
                continue;
            }

            contrato = new Contrato(id, periodo, cliente, jogo);

            if (contratos.adicionar(contrato)) {
                System.out.println(contrato.descrever());
                cliente.addContrato(contrato);
                jogo.addContrato(contrato);
            } else { System.out.println("4:erro-id repetido."); }
        }

        // Passo 5
        int codigo = Integer.parseInt(IO.getEntrada());
        jogo = jogos.buscar(codigo);
        if (jogo == null) {
            System.out.println("5:erro-codigo inexistente.");
        } else {
            System.out.println("5:" + jogo.getCodigo() + ";" 
                                    + jogo.getNome() + ";"
                                    + jogo.getCategoria().getDescricao());
        }

        // Passo 6
        Categoria categoria;
        try {
            categoria = Categoria.valueOf(IO.getEntrada());
            ArrayList<Jogo> jogosCategoria = jogos.buscar(categoria);
            if (jogosCategoria.isEmpty()) {
                System.out.println("6:erro-nenhum jogo encontrado.");
            } else {
                for (Jogo j : jogosCategoria) {
                    System.out.println("6:" + j.getCategoria().getDescricao() + ";" 
                                            + j.getCodigo() + ";"
                                            + j.getNome());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("6:erro-categoria inexistente.");
        }

        // Passo 7
        int numero = Integer.parseInt(IO.getEntrada());
        String nome = IO.getEntrada();

        cliente = clientes.buscar(numero);
        if (cliente == null) {
            System.out.println("7:erro-numero inexistente.");
        } else {
            cliente.setNome(nome);
            System.out.println(cliente.descrever().replaceFirst("1","7"));
        }

        // Passo 8
        codigo = Integer.parseInt(IO.getEntrada());

        jogo = jogos.buscar(codigo);
        if (jogo == null){
            System.out.println("8:erro-codigo inexistente.");
        } else {
            ArrayList<Contrato> lista_contratos = contratos.buscar(jogo);
            if (!lista_contratos.isEmpty()) {
                for (Contrato c : lista_contratos) {
                    System.out.println("8:contrato removido: " + c.getId());
                    contratos.remover(c);
                }
            } else { System.out.println("8:nenhum contrato encontrado."); }
        }
            
        // Passo 9
        ArrayList<Contrato> lista_contratos = contratos.getCopia();
        if (!lista_contratos.isEmpty()) {
            for (Contrato c : lista_contratos) {
                System.out.println(c.descrever().replaceFirst("4","9"));
            }
        } else { System.out.println("9:erro-nenhum contrato cadastrado."); }

        // Passo 10
        lista_contratos = contratos.getCopia();
        if (!lista_contratos.isEmpty()) {  
            double maiorValor = 0.0;
            Cliente clienteMaiorValor = null;
            
            for (Contrato c : lista_contratos) {
                int numeroCliente = c.getCliente().getNumero();
                double somaCliente = 0.0;
                
                for (Contrato cc : lista_contratos) {
                    if (cc.getCliente().getNumero() == numeroCliente) {
                        somaCliente += cc.getJogo().getValorMinuto();
                    }
                }
                if (somaCliente > maiorValor) {
                    maiorValor = somaCliente;
                    clienteMaiorValor = c.getCliente();
                }
            }

            if (clienteMaiorValor != null) {
                System.out.print("10:" + clienteMaiorValor.getNumero() + ";" 
                                         + clienteMaiorValor.getNome() + ";"
                                         + clienteMaiorValor.getEmail() + ";"
                                         + String.format("%.1f", maiorValor));
            }
        } else { System.out.print("10:erro-nenhum contrato encontrado."); }
    }
   
}