package view;

import controllers.CaixaController;
import java.util.Scanner;

public class MenuCaixa {
    public void mostrarMenuCaixa(Scanner scanner, CaixaController caixaController) {
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
