package view;

import controllers.PacienteController;
import controllers.MedicoController;
import controllers.CaixaController;
import controllers.ConsultaController;
import models.Paciente;
import models.Medico;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        CaixaController caixaController = new CaixaController();
        MedicoController medicoController = new MedicoController();
        PacienteController pacienteController = new PacienteController();
        ConsultaController consultaController = new ConsultaController(pacienteController.getPacientes(), medicoController.getMedicos());

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Paciente");
            System.out.println("2. Medico");
            System.out.println("3. Consultas");
            System.out.println("4. Caixa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    mostrarMenuPaciente(scanner, pacienteController);
                    break;
                case 2:
                    mostrarMenuMedico(scanner, medicoController);
                    break;
                case 3:
                    mostrarMenuConsultas(scanner, consultaController);
                    break;
                case 4:
                    mostrarMenuCaixa(scanner, caixaController);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (option != 5);

        scanner.close();
    }

    private void mostrarMenuPaciente(Scanner scanner, PacienteController pacienteController) {
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

    private void mostrarMenuMedico(Scanner scanner, MedicoController medicoController) {
        int medicoOption;
        do {
            System.out.println("===== Menu Médico =====");
            System.out.println("1. Criar Médico");
            System.out.println("2. Alterar Médico");
            System.out.println("3. Ver Médicos Cadastrados");
            System.out.println("4. Deletar Médico");
            System.out.println("5. Voltar ao menu principal");
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
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (medicoOption != 5);
    }

    private void mostrarMenuConsultas(Scanner scanner, ConsultaController consultaController) {
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

    private void mostrarMenuCaixa(Scanner scanner, CaixaController caixaController) {
        int caixaOption;
        do {
            System.out.println("===== Menu Caixa =====");
            System.out.println("1. Registrar Entrada (Pagamento de Consulta)");
            System.out.println("2. Registrar Saída (Despesa)");
            System.out.println("3. Ver Extrato");
            System.out.println("4. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            caixaOption = scanner.nextInt();

            switch (caixaOption) {
                case 1:
                    System.out.print("Digite o valor da entrada (pagamento): R$ ");
                    double valorEntrada = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a descrição da entrada: ");
                    String descricaoEntrada = scanner.nextLine();

                    System.out.print("Digite a forma de pagamento (ex: Dinheiro, Cartão): ");
                    String formaPagamentoEntrada = scanner.nextLine();

                    caixaController.registrarEntrada(valorEntrada, descricaoEntrada, formaPagamentoEntrada);
                    break;

                case 2:
                    System.out.print("Digite o valor da saída (despesa): R$ ");
                    double valorSaida = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a descrição da saída: ");
                    String descricaoSaida = scanner.nextLine();

                    System.out.print("Digite a forma de pagamento (ex: Dinheiro, Cartão): ");
                    String formaPagamentoSaida = scanner.nextLine();

                    caixaController.registrarSaida(valorSaida, descricaoSaida, formaPagamentoSaida);
                    break;

                case 3:
                    caixaController.exibirExtrato();
                    break;

                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (caixaOption != 4);
    }
}
