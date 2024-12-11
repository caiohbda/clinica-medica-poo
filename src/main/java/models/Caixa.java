package models;

import jakarta.persistence.*;
import utils.DataUtil;
import java.util.Date;

@Table(name = "Caixa")
@Entity
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data")
    private Date data;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "formaPagamento")
    private String formaPagamento;

    public Caixa() {
    }

    public Caixa(int id, String tipo, double valor, Date data, String descricao, String formaPagamento) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.formaPagamento = formaPagamento;
    }

    // Getters e setters
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
