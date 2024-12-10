package models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "receituarios")
public class Receituario {

    @Id
    @Column(name = "id_receituario")
    private String idReceituario;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @Column(name = "data_emissao", nullable = false)
    private LocalDate dataEmissao;

    @Column(name = "medicamentos", nullable = false, columnDefinition = "TEXT")
    private String medicamentos;

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    // Construtores, getters e setters
    public Receituario() {
    }

    public Receituario(String idReceituario, Paciente paciente, Medico medico, LocalDate dataEmissao, String medicamentos, String observacoes) {
        this.idReceituario = idReceituario;
        this.paciente = paciente;
        this.medico = medico;
        this.dataEmissao = dataEmissao;
        this.medicamentos = medicamentos;
        this.observacoes = observacoes;
    }

    public String getIdReceituario() {
        return idReceituario;
    }

    public void setIdReceituario(String idReceituario) {
        this.idReceituario = idReceituario;
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

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void exibirReceituario() {
        System.out.println("===== Receituário =====");
        System.out.println("ID: " + idReceituario);
        System.out.println("Paciente: " + paciente.getNome() + " (CPF: " + paciente.getCPF() + ")");
        System.out.println("Médico: " + medico.getNome() + " (CRM: " + medico.getCrm() + ")");
        System.out.println("Data de Emissão: " + dataEmissao);
        System.out.println("Medicamentos: " + medicamentos);
        System.out.println("Observações: " + observacoes);
    }
}
