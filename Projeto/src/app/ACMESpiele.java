package app;

import dados.*;

public class ACMESpiele {
    private GerenciadorIOArquivos IO = new GerenciadorIOArquivos("datain.txt", "dataout.txt");;
    private Clientes clientes = new Clientes();
    private Jogos jogos = new Jogos();
    private Contratos contratos = new Contratos();

    public ACMESpiele() {
        // Inicializa o gerenciador de E/S e redireciona entrada/saída
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

            clientes.adicionar(cliente);
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

            clientes.adicionar(cliente);
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

            jogos.adicionar(jogo);
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

            contratos.adicionar(contrato);
        }
    }
   
}