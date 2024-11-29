package controllers;
import Interfaces.IPacienteController;
import models.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacienteController implements IPacienteController {
    private final List<Paciente> pacientes = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    @Override
    public void criarPaciente() {
        System.out.print("Digite o CPF do paciente: ");
        String CPF = input.next();

        System.out.print("Digite o nome do paciente: ");
        String nome = input.next();

        System.out.print("Digite a idade do paciente: ");
        String idade = input.next();

        Paciente paciente = new Paciente(CPF, nome, idade);

        pacientes.add(paciente);

        System.out.println("Paciente criado com sucesso!");
    }

    @Override
    public void alterarPaciente() {
        System.out.print("Digite o CPF do paciente a ser alterado: ");
        String CPF = input.next();

        Paciente pacienteEncontrado = null;
        for (Paciente p : pacientes) {
            if (p.getCPF().equals(CPF)) {
                pacienteEncontrado = p;
                break;
            }
        }

        if (pacienteEncontrado != null) {
            System.out.println("Paciente encontrado!");
            System.out.println("Nome atual: " + pacienteEncontrado.getNome());
            System.out.println("Idade atual: " + pacienteEncontrado.getIdade());
            System.out.println("O que deseja alterar?");
            System.out.println("1. Nome");
            System.out.println("2. Idade");
            System.out.println("3. Cancelar");

            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = input.next();
                    pacienteEncontrado.setNome(novoNome);
                    System.out.println("Nome alterado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite a nova idade: ");
                    String novaIdade = input.next();
                    pacienteEncontrado.setIdade(novaIdade);
                    System.out.println("Idade alterada com sucesso!");
                    break;

                case 3:
                    System.out.println("Alteração cancelada.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    @Override
    public void removerPaciente() {
        System.out.print("Digite o CPF do paciente a remover: ");
        String CPF = input.next();

        Paciente pacienteRemovido = null;
        for (Paciente p : pacientes) {
            if (p.getCPF().equals(CPF)) {
                pacienteRemovido = p;
                break;
            }
        }

        if (pacienteRemovido != null) {
            pacientes.remove(pacienteRemovido);
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    @Override
    public void buscarPacientePorCPF() {
        System.out.print("Digite o CPF do paciente: ");
        String CPF = input.next();

        Paciente pacienteEncontrado = null;
        for (Paciente p : pacientes) {
            if (p.getCPF().equals(CPF)) {
                pacienteEncontrado = p;
                break;
            }
        }

        if (pacienteEncontrado != null) {
            System.out.println("Informações do Paciente:");
            System.out.println("Nome: " + pacienteEncontrado.getNome());
            System.out.println("Idade: " + pacienteEncontrado.getIdade());
            System.out.println("CPF: " + pacienteEncontrado.getCPF());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    @Override
    public void listarTodosPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            System.out.println("Listando todos os pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println("Nome: " + paciente.getNome() + ", CPF: " + paciente.getCPF() + ", Idade: " + paciente.getIdade());
            }
        }
    }
}
