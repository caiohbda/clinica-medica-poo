package view;

import controllers.PacienteController;
import controllers.MedicoController;
import controllers.CaixaController;
import controllers.ConsultaController;
import controllers.ReceituarioController;

import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        CaixaController caixaController = new CaixaController();
        MedicoController medicoController = new MedicoController();
        PacienteController pacienteController = new PacienteController();
        ConsultaController consultaController = new ConsultaController(pacienteController.getPacientes(), medicoController.getMedicos());
        ReceituarioController receituarioController = new ReceituarioController(
                pacienteController.getPacientes(), medicoController.getMedicos()
        );

        MenuPaciente menuPaciente = new MenuPaciente();
        MenuMedico menuMedico = new MenuMedico();
        MenuConsultas menuConsultas = new MenuConsultas();
        MenuCaixa menuCaixa = new MenuCaixa();
        MenuReceituario menuReceituario = new MenuReceituario(receituarioController);

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Paciente");
            System.out.println("2. Médico");
            System.out.println("3. Consultas");
            System.out.println("4. Caixa");
            System.out.println("5. Receituário");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    menuPaciente.mostrarMenuPaciente(scanner, pacienteController);
                    break;
                case 2:
                    menuMedico.mostrarMenuMedico(scanner, medicoController);
                    break;
                case 3:
                    menuConsultas.mostrarMenuConsultas(scanner, consultaController);
                    break;
                case 4:
                    menuCaixa.mostrarMenuCaixa(scanner, caixaController);
                    break;
                case 5:
                    menuReceituario.MostrarMenuReceituario();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (option != 6);

        scanner.close();
    }
}
