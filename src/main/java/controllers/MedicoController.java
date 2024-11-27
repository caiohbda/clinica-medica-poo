package controllers;
import Interfaces.IMedicoController;
import models.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicoController implements IMedicoController {
    private List<Medico> medicos = new ArrayList<>();
    private Scanner input = new Scanner(System.in);


    public List<Medico> getMedicos() {
        return medicos;
    }
    @Override
    public void criarMedico() {
        System.out.print("Digite o CRM do médico: ");
        String crm = input.next();

        System.out.print("Digite o nome do médico: ");
        String nome = input.next();

        System.out.print("Digite a especialidade do médico: ");
        String especialidade = input.next();

        System.out.print("Digite a idade do médico: ");
        String idade = input.next();

        Medico medico = new Medico(crm, nome, especialidade, idade);

        medicos.add(medico);

        System.out.println("Médico criado com sucesso!");
    }
    @Override
    public void alterarMedico() {
        System.out.print("Digite o CRM do médico a ser alterado: ");
        String crm = input.next();

        Medico medicoEncontrado = null;
        for (Medico m : medicos) {
            if (m.getCrm().equals(crm)) {
                medicoEncontrado = m;
                break;
            }
        }

        if (medicoEncontrado != null) {
            System.out.println("Médico encontrado!");
            System.out.println("Nome atual: " + medicoEncontrado.getNome());
            System.out.println("Especialidade atual: " + medicoEncontrado.getEspecialidade());
            System.out.println("Idade atual: " + medicoEncontrado.getIdade());

            System.out.println("O que deseja alterar?");
            System.out.println("1. Nome");
            System.out.println("2. Especialidade");
            System.out.println("3. Idade");
            System.out.println("4. Cancelar");

            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = input.next();
                    medicoEncontrado.setNome(novoNome);
                    System.out.println("Nome alterado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite a nova especialidade: ");
                    String novaEspecialidade = input.next();
                    medicoEncontrado.setEspecialidade(novaEspecialidade);
                    System.out.println("Especialidade alterada com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite a nova idade: ");
                    String novaIdade = input.next();
                    medicoEncontrado.setIdade(novaIdade);
                    System.out.println("Idade alterada com sucesso!");
                    break;
                case 4:
                    System.out.println("Alteração cancelada.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
    @Override
    public void removerMedico() {
        System.out.print("Digite o CRM do médico a remover: ");
        String crm = input.next();

        Medico medicoRemovido = null;
        for (Medico m : medicos) {
            if (m.getCrm().equals(crm)) {
                medicoRemovido = m;
                break;
            }
        }

        if (medicoRemovido != null) {
            medicos.remove(medicoRemovido);
            System.out.println("Médico removido com sucesso!");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
    @Override
    public void listarTodosMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Não há médicos cadastrados.");
        } else {
            System.out.println("Listando todos os médicos:");
            for (Medico medico : medicos) {
                medico.exibirMedico();
                System.out.println("---------------------------------");
            }
        }
    }
}
