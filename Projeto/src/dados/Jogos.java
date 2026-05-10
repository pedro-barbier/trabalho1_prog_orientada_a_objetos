package dados;

import java.util.ArrayList;

public class Jogos {
    private ArrayList<Jogo> jogos = new ArrayList<>();

    public boolean adicionar(Jogo jogo){
        if (buscar(jogo.getCodigo()) == null){
            jogos.add(jogo);
            return true;
        } 
        return false;
    }

    public boolean remover(Jogo jogo){
        return jogos.remove(jogo);
    }

    public boolean remover(int codigo){
        return jogos.remove(buscar(codigo));
    }

    public Jogo buscar(int codigo){
        for (Jogo jogo : jogos) {
            if (jogo.getCodigo() == codigo) return jogo;
        }
        return null;
    }

    public ArrayList<Jogo> buscar(Categoria categoria){
        ArrayList<Jogo> temp = new ArrayList<>();
        for (Jogo jogo : jogos) {
            if (jogo.getCategoria().equals(categoria)) {
                temp.add(jogo);
            }
        }
        return temp;
    }

    public ArrayList<Jogo> getCopia(){
        ArrayList<Jogo> copia = new ArrayList<>(jogos.size());
        for (Jogo j : jogos) {
            copia.add(j);
        }
        return copia;
    }
}
