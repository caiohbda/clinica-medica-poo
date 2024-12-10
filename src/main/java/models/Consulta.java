package models;

import jakarta.persistence.*;
import utils.DataUtil;
import java.util.Date;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_consulta", nullable = false)
    private Date dataConsulta;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private double valor;

    public Consulta() {
    }

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
