package models;

import java.util.Date;
import utils.DataUtil;

public class Consulta {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private Date dataConsulta;
    private String descricao;
    private double valor;

    public Consulta(int id, Paciente paciente, Medico medico, Date dataConsulta, String descricao, double valor) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataConsulta = dataConsulta;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void exibirConsulta() {
        System.out.println("ID da Consulta: " + id);
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Data da Consulta: " + DataUtil.formatarData(dataConsulta));
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: R$ " + valor);
    }
}
