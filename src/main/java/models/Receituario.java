package models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "receituarios")
public class Receituario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Agora o id é do tipo int

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

    public Receituario(Paciente paciente, Medico medico, String medicamentos, String observacoes, LocalDate dataEmissao) {
        this.paciente = paciente;
        this.medico = medico;
        this.medicamentos = medicamentos;
        this.observacoes = observacoes;
        this.dataEmissao = dataEmissao;
    }

    public Receituario() {

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
        System.out.println("===== Receita =====");
        System.out.println("ID: " + id);  // Agora o ID é acessado por "id"
        System.out.println("Paciente: " + paciente.getNome() + " (CPF: " + paciente.getCPF() + ")");
        System.out.println("Médico: " + medico.getNome() + " (CRM: " + medico.getCrm() + ")");
        System.out.println("Data de Emissão: " + dataEmissao);
        System.out.println("Medicamentos: " + medicamentos);
        System.out.println("Observações: " + observacoes);
        System.out.println("========================");
    }
}
