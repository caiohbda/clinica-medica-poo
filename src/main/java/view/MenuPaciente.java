package view;

import controllers.PacienteController;
import java.util.Scanner;

public class MenuPaciente {
    public void mostrarMenuPaciente(Scanner scanner, PacienteController pacienteController) {
        int pacienteOption;
        do {
            System.out.println("===== Menu Paciente =====");
            System.out.println("1. Criar Paciente");
            System.out.println("2. Buscar Paciente");
            System.out.println("3. Alterar Paciente");
            System.out.println("4. Ver Pacientes Cadastrados");
            System.out.println("5. Deletar Paciente");
            System.out.println("6. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            pacienteOption = scanner.nextInt();

            switch (pacienteOption) {
                case 1:
                    pacienteController.criarPaciente();
                    break;
                case 2:
                    pacienteController.buscarPacientePorCPF();
                    break;
                case 3:
                    pacienteController.alterarPaciente();
                    break;
                case 4:
                    pacienteController.listarTodosPacientes();
                    break;
                case 5:
                    pacienteController.removerPaciente();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (pacienteOption != 6);
    }
}
