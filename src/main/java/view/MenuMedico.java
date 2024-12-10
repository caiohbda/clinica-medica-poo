package view;

import controllers.MedicoController;
import java.util.Scanner;

public class MenuMedico {
    public void mostrarMenuMedico(Scanner scanner, MedicoController medicoController) {
        int medicoOption;
        do {
            System.out.println("===== Menu Médico =====");
            System.out.println("1. Criar Médico");
            System.out.println("2. Alterar Médico");
            System.out.println("3. Ver Médicos Cadastrados");
            System.out.println("4. Deletar Médico");
            System.out.println("5. Buscar Medico pelo Id");
            System.out.println("6. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            medicoOption = scanner.nextInt();

            switch (medicoOption) {
                case 1:
                    medicoController.criarMedico();
                    break;
                case 2:
                    medicoController.alterarMedico();
                    break;
                case 3:
                    medicoController.listarTodosMedicos();
                    break;
                case 4:
                    medicoController.removerMedico();
                    break;
                case 5:
                    medicoController.buscarMedicoPorId();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (medicoOption != 6);
    }
}
