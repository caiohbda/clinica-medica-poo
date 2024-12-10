package models;

import jakarta.persistence.*;

@Table(name="medico")
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "crm")
    private String crm;
    @Column(name = "nome")
    private String nome;
    @Column(name = "especialidade")
    private String especialidade;
    @Column(name = "idade")
    private String idade;

    public Medico(String crm, String nome, String especialidade, String idade) {
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.idade = idade;
    }

    public Medico() {

    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void exibirMedico() {
        System.out.println("=====MEDICO=====");
        System.out.println("Id: " + this.getId());
        System.out.println("Nome do Medico: " + this.getNome());
        System.out.println("CRM do Medico: " + this.getCrm());
        System.out.println("Especialidade do Medico: " + this.getEspecialidade());
        System.out.println("Idade do Medico: " + this.getIdade());
        System.out.println("===================");
    }
}
