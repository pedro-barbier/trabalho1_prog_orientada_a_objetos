package dados;

import java.util.ArrayList;

public abstract class Cliente {
    private int numero;
    private String nome;
    private String email;
    private ArrayList<Contrato> contratos;

    public Cliente(int numero, String nome, String email) {
        this.numero = numero;
        this.nome = nome;
        this.email = email;
        contratos = new ArrayList<>();
    }

    public abstract String descrever();

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public ArrayList<Contrato> getContratos() {
        ArrayList<Contrato> aux = new ArrayList<>();
        for (Contrato c : contratos) {
            aux.add(c);
        }
        return aux;
    }
    
}
