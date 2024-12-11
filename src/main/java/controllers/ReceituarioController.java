package controllers;

import Interfaces.IReceituarioController;
import models.Receituario;
import models.Paciente;
import models.Medico;
import repositories.ReceituarioRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceituarioController implements IReceituarioController {

    private List<Receituario> cacheReceituarios = new ArrayList<>();
    private final List<Paciente> cachePacientes;
    private final List<Medico> cacheMedicos;

    private final ReceituarioRepository rr = new ReceituarioRepository();

    public ReceituarioController(List<Paciente> pacientes, List<Medico> medicos) {
        this.cachePacientes = pacientes;
        this.cacheMedicos = medicos;
    }

    public void criarReceituario(Scanner scanner) {
        System.out.println("===== Criar Receituário =====");

        System.out.println("Selecione o paciente pelo CPF:");
        for (Paciente paciente : cachePacientes) {
            System.out.println("Nome: " + paciente.getNome() + " | CPF: " + paciente.getCPF());
        }
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.next();
        Paciente pacienteSelecionado = cachePacientes.stream()
                .filter(p -> p.getCPF().equals(cpfPaciente))
                .findFirst()
                .orElse(null);

        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Selecione o médico pelo CRM:");
        for (Medico medico : cacheMedicos) {
            System.out.println("Nome: " + medico.getNome() + " | CRM: " + medico.getCrm());
        }
        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.next();
        Medico medicoSelecionado = cacheMedicos.stream()
                .filter(m -> m.getCrm().equals(crmMedico))
                .findFirst()
                .orElse(null);

        if (medicoSelecionado == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Digite os medicamentos prescritos: ");
        scanner.nextLine(); // Limpa o buffer do scanner
        String medicamentos = scanner.nextLine();

        System.out.print("Digite as observações do receituário: ");
        String observacoes = scanner.nextLine();

        LocalDate dataCriacao = LocalDate.now();

        Receituario receituario = new Receituario(pacienteSelecionado, medicoSelecionado, medicamentos, observacoes, dataCriacao);
        rr.save(receituario);
        cacheReceituarios.add(receituario);

        System.out.println("Receituário criado com sucesso! ID: " + receituario.getId());
    }

    public List<Receituario> listarReceituarios() {
        cacheReceituarios = rr.findAll();
        if (cacheReceituarios.isEmpty()) {
            System.out.println("Não há receituários cadastrados.");
        } else {
            System.out.println("===== Receituários =====");
            for (Receituario receituario : cacheReceituarios) {
                receituario.exibirReceituario();
            }
        }
        return cacheReceituarios;
    }

    public void removerReceituario(Scanner scanner) {
        System.out.println("===== Remover Receituário =====");
        listarReceituarios();

        System.out.print("Digite o ID do receituário a ser removido: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido para o ID do receituário.");
            scanner.next();
            System.out.print("Digite o ID do receituário a ser removido: ");
        }
        int idReceituario = scanner.nextInt();

        boolean receituarioRemovido = false;
        for (Receituario receituario : cacheReceituarios) {
            if (receituario.getId() == idReceituario) {
                rr.delete(idReceituario);
                cacheReceituarios.remove(receituario);
                receituarioRemovido = true;
                System.out.println("Receituário removido com sucesso!");
                break;
            }
        }

        if (!receituarioRemovido) {
            System.out.println("Receituário não encontrado.");
        }
    }

    public void alterarReceituario(Scanner scanner) {
        System.out.println("===== Alterar Receituário =====");
        listarReceituarios();

        System.out.print("Digite o ID do receituário a ser alterado: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido para o ID do receituário.");
            scanner.next();
            System.out.print("Digite o ID do receituário a ser alterado: ");
        }
        int idReceituario = scanner.nextInt();

        Receituario receituario = cacheReceituarios.stream()
                .filter(r -> r.getId() == idReceituario)
                .findFirst()
                .orElse(null);

        if (receituario == null) {
            System.out.println("Receituário não encontrado.");
            return;
        }

        System.out.println("Receituário encontrado. Vamos alterar os dados.");

        System.out.print("Digite os novos medicamentos (ou pressione Enter para manter): ");
        scanner.nextLine();
        String novosMedicamentos = scanner.nextLine();
        if (!novosMedicamentos.isEmpty()) {
            receituario.setMedicamentos(novosMedicamentos);
        }

        System.out.print("Digite as novas observações (ou pressione Enter para manter): ");
        String novasObservacoes = scanner.nextLine();
        if (!novasObservacoes.isEmpty()) {
            receituario.setObservacoes(novasObservacoes);
        }

        rr.update(receituario);

        System.out.println("Receituário alterado com sucesso!");
    }
}
