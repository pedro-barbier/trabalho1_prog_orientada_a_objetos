package dados;

public abstract class Clientes {
    private int numero;
    private String nome;
    private String email;

    public Clientes(int numero, String nome, String email) {
        this.numero = numero;
        this.nome = nome;
        this.email = email;
    }

    public abstract String descrever();
}
