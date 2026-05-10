package dados;

import java.util.ArrayList;

public class Jogo {
    private int codigo;
    private String nome;
    private int ano;
    private double valorMinuto;
    private Categoria categoria;
    private ArrayList<Contrato> contratos;


    public Jogo(int codigo, String nome, int ano, double valorMinuto, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.ano = ano;
        this.valorMinuto = valorMinuto;
        this.categoria = categoria;
        contratos = new ArrayList<>();
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorMinuto() {
        return this.valorMinuto;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public String descrever() {
        return "3:" + getCodigo() + ";" 
                    + getNome() + ";"
                    + getAno() + ";"
                    + getValorMinuto() + ";"
                    + getCategoria().getDescricao();
    }
}
