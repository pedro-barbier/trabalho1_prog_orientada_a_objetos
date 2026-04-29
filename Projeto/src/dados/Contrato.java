package dados;

public class Contrato {
    private int id;
    private int periodo;
    private Jogo jogo;
    private Cliente cliente;

    public Contrato(int id, int periodo, Cliente cliente, Jogo jogo) {
        this.id = id;
        this.periodo = periodo;
        this.cliente = cliente;
        this.jogo = jogo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Jogo getJogo() {
        return this.jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String descrever() {
        return "4:" + getId() + ";" 
                    + getPeriodo() + ";"
                    + getCliente().getNumero() + ";"
                    + getJogo().getCodigo();
    }
}
