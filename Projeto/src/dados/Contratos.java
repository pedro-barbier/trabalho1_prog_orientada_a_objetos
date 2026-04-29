package dados;

import java.util.ArrayList;

public class Contratos {
    private ArrayList<Contrato> contratos = new ArrayList<>();

    public boolean adicionar(Contrato contrato){
        if (buscar(contrato.getId()) == null){
            contratos.add(contrato);
            return true;
        }
        return false;
    }

    public boolean remover(Contrato contrato){
        return contratos.remove(contrato);
    }

    public boolean remover(int id){
        return contratos.remove(buscar(id));
    }

    public Contrato buscar(int id){
        for (Contrato c : contratos) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public ArrayList<Contrato> buscar(Cliente cliente){
        ArrayList<Contrato> temp = new ArrayList<>();
        for (Contrato c : contratos) {
            if (c.getCliente().equals(cliente)) {
                temp.add(c);
            }
        }
        return temp;
    }
    
    public ArrayList<Contrato> buscar(Jogo jogo){
        ArrayList<Contrato> temp = new ArrayList<>();
        for (Contrato c : contratos) {
            if (c.getJogo().equals(jogo)) {
                temp.add(c);
            }
        }
        return temp;
    }

    public ArrayList<Contrato> getCopyOfContratos(){
        ArrayList<Contrato> copia = new ArrayList<>(contratos.size());
        for (Contrato c : contratos) {
            copia.add(c);
        }
        return copia;
    }
}
