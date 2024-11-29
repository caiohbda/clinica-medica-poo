package view;

import java.util.Scanner;
import controllers.ReceituarioController;

public class MenuReceituario {
    private ReceituarioController controller;
    private Scanner input;

    public MenuReceituario(ReceituarioController controller) {
        this.controller = controller;
        this.input = new Scanner(System.in);
    }

    public boolean MostrarMenuReceituario() {
        while (true) {
            System.out.println("===== Menu de Receituário =====");
            System.out.println("1. Criar Receituário");
            System.out.println("2. Alterar Receituário");
            System.out.println("3. Remover Receituário");
            System.out.println("4. Listar Todos os Receituários");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    controller.criarReceituario();
                    break;
                case 2:
                    controller.alterarReceituario();
                    break;
                case 3:
                    controller.removerReceituario();
                    break;
                case 4:
                    controller.listarTodosReceituarios();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    return false;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
