package view;

import controllers.ConsultaController;
import java.util.Scanner;

public class MenuConsultas {
    public void mostrarMenuConsultas(Scanner scanner, ConsultaController consultaController) {
        int consultasOption;
        do {
            System.out.println("===== Menu Consultas =====");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Alterar Consulta");
            System.out.println("3. Ver Consultas Agendadas");
            System.out.println("4. Cancelar Consulta");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            consultasOption = scanner.nextInt();

            switch (consultasOption) {
                case 1:
                    consultaController.agendarConsulta(scanner);
                    break;
                case 2:
                    consultaController.alterarConsulta(scanner);
                    break;
                case 3:
                    consultaController.listarConsultas();
                    break;
                case 4:
                    consultaController.cancelarConsulta(scanner);
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (consultasOption != 5);
    }
}
