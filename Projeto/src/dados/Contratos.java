package dados;

import java.util.ArrayList;

public class Contratos {
    private ArrayList<Contrato> contratos = new ArrayList<>();

    public void adicionar(Contrato c){
        if (buscar(c.getId()) == null){
            contratos.add(c);
            System.out.println(c.descrever());
        } else {
           System.out.println("4:erro-id repetido.");
        }
    }

    public boolean remover(Contrato c){
        return contratos.remove(c);
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
}
