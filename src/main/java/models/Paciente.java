package models;

import jakarta.persistence.*;

@Table(name = "paciente")
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "cpf")
    private String CPF;
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private String idade;


    public Paciente(String CPF, String nome, String idade) {
        this.CPF = CPF;
        this.nome = nome;
        this.idade = idade;
    }


    public Paciente() {
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void exibirPaciente() {
        System.out.println("=====PACIENTE=====");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("===================");
    }
}
