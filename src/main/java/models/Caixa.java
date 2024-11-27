package models;

import utils.DataUtil;
import java.util.Date;

public class Caixa {

    private int id;
    private String tipo;
    private double valor;
    private Date data;
    private String descricao;
    private String formaPagamento;

    public Caixa(int id, String tipo, double valor, Date data, String descricao, String formaPagamento) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void exibirMovimentacao() {
        System.out.println("ID: " + id);
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Data: " + DataUtil.formatarData(data));
        System.out.println("Descrição: " + descricao);
        System.out.println("Forma de Pagamento: " + formaPagamento);
    }
}
