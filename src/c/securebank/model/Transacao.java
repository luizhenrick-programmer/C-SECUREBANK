package c.securebank.model;

public class Transacao {
    private double valor;
    private String descricao;
    private String dataHora;

    public Transacao(double valor, String descricao, String dataHora) {
        this.valor = valor;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataHora() {
        return dataHora;
    }
}