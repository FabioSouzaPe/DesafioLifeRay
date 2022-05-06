package model;

public class Produto {

    private String nome;
    private Double valor;
    private boolean importado;
    private boolean retemImpostoDeVenda;

    public Produto(String nome, Double valor, boolean importado, boolean retemImpostoDeVenda) {
        this.nome = nome;
        this.valor = valor;
        this.importado = importado;
        this.retemImpostoDeVenda = retemImpostoDeVenda;
    }

    public Produto() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    public boolean isRetemImpostoDeVenda() {
        return retemImpostoDeVenda;
    }

    public void setRetemImpostoDeVenda(boolean retemImpostoDeVenda) {
        this.retemImpostoDeVenda = retemImpostoDeVenda;
    }

}
