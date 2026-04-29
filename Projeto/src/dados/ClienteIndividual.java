package dados;

public class ClienteIndividual extends Cliente {
    private String cpf;

    public ClienteIndividual(int numero, String nome, String email, String cpf) {
        super(numero, nome, email);
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String descrever() {
        return "1:" + getNumero() + ";" 
                    + getNome() + ";"
                    + getEmail() + ";"
                    + getCpf();
    }
}
