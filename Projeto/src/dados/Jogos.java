package dados;

import java.util.ArrayList;

public class Jogos {
    private ArrayList<Jogo> jogos = new ArrayList<>();

    public void adicionar(Jogo j){
        if (buscar(j.getCodigo()) == null){
            jogos.add(j);
            System.out.println(j.descrever());
        } else {
           System.out.println("3:erro-codigo repetido.");
        }
    }

    public boolean remover(Jogo j){
        return jogos.remove(j);
    }

    public boolean remover(int n){
        return jogos.remove(buscar(n));
    }

    public Jogo buscar(int n){
        for (Jogo jogo : jogos) {
            if (jogo.getCodigo() == n) return jogo;
        }
        return null;
    }

    public ArrayList<Jogo> buscar(Categoria cat){
        ArrayList<Jogo> temp = new ArrayList<>();
        for (Jogo jogo : jogos) {
            if (jogo.getCategoria().equals(cat)) {
                temp.add(jogo);
            }
        }
        return temp;
    }

    public void consultarJogoCodigo(int cod) {
        Jogo jogo = buscar(cod);
        if (jogo == null) {
            System.out.println("5:erro-codigo inexistente.");
        } else {
            System.out.println("5:" + jogo.getCodigo() + ";" 
                                    + jogo.getNome() + ";"
                                    + jogo.getCategoria().getDescricao());
        }
    }

    public void consultarJogoCategoria(Categoria cat) {
        ArrayList<Jogo> jogosCategoria = buscar(cat);
        if (jogosCategoria.isEmpty()) {
            System.out.println("6:erro-nenhum jogo encontrado.");
        } else {
            for (Jogo jogo : jogosCategoria) {
                System.out.println("6:" + jogo.getCategoria().getDescricao() + ";" 
                                        + jogo.getCodigo() + ";"
                                        + jogo.getNome());
            }
        }
    }
}
