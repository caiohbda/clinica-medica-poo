package models;

public class Paciente {

    private String CPF;
    private String nome;
    private String idade;

    public Paciente(String CPF, String nome, String idade) {
        this.CPF = CPF;
        this.nome = nome;
        this.idade = idade;
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
        System.out.println("CPF: " + CPF);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}
