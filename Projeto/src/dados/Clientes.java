package dados;

import java.util.ArrayList;

public class Clientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente c){
        if (buscar(c.getNumero()) == null){
            clientes.add(c);
            System.out.println(c.descrever());
        } else {
            if (c instanceof ClienteIndividual) {
                System.out.println("1:erro-numero repetido.");
            } else {
                System.out.println("2:erro-numero repetido.");
            }
        }
    }

    public boolean remover(Cliente c){
        return clientes.remove(c);
    }

    public boolean remover(int n){
        return clientes.remove(buscar(n));
    }

    public Cliente buscar(int n){
        for (Cliente cliente : clientes) {
            if (cliente.getNumero() == n) return cliente;
        }
        return null;
    }
}
