package models;

public class Medico {

    private String crm;
    private String nome;
    private String especialidade;
    private String idade;

    public Medico(String crm, String nome, String especialidade, String idade) {
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.idade = idade;
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

    public void exibirMedico() {
        System.out.println("CRM: " + crm);
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Idade: " + idade);
    }
}
