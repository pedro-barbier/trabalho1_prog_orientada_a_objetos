package dados;

public class ClienteIndividual extends Clientes {
    private String cpf;

    public ClienteIndividual(int numero, String nome, String email, String cpf) {
        super(numero, nome, email);
        this.cpf = cpf;
    }

    @Override
    public String descrever() {
        return null;
    }
}
