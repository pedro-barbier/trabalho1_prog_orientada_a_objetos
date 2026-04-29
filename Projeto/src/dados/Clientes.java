package dados;

import java.util.ArrayList;

public class Clientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public boolean adicionar(Cliente c){
        if (buscar(c.getNumero()) == null){
            clientes.add(c);
            return true;
        } 
        return false;
    }

    public boolean remover(Cliente c){
        return clientes.remove(c);
    }

    public boolean remover(int numero){
        return clientes.remove(buscar(numero));
    }

    public Cliente buscar(int numero){
        for (Cliente cliente : clientes) {
            if (cliente.getNumero() == numero) return cliente;
        }
        return null;
    }

    public ArrayList<Cliente> getCopyOfClientes(){
        ArrayList<Cliente> copia = new ArrayList<>(clientes.size());
        for (Cliente c : clientes) {
            copia.add(c);
        }
        return copia;
    }
}
