package dados;

public class ClienteCorporativo extends Clientes {
    private String cnpj;
    private String nome_fantasia;

    public ClienteCorporativo(int numero, String nome, String email, String cnpj, String nome_fantasia) {
        super(numero, nome, email);
        this.cnpj = cnpj;
        this.nome_fantasia = nome_fantasia;
    }

    @Override
    public String descrever() {
        return null;
    }
}
