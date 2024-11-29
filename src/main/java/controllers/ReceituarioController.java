package controllers;

import models.Receituario;
import models.Paciente;
import models.Medico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceituarioController {
    private final List<Receituario> receituarios = new ArrayList<>();
    private final List<Paciente> pacientes;
    private final List<Medico> medicos;
    private final Scanner scanner = new Scanner(System.in);
    private static int ultimoId = 0;

    public ReceituarioController(List<Paciente> pacientes, List<Medico> medicos) {
        this.pacientes = pacientes;
        this.medicos = medicos;
    }

    public void criarReceituario() {
        String idReceituario = String.valueOf(++ultimoId);

        System.out.println("Selecione o paciente pelo CPF:");
        for (Paciente p : pacientes) {
            System.out.println("Nome: " + p.getNome() + " | CPF: " + p.getCPF());
        }
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.next();
        Paciente pacienteSelecionado = pacientes.stream()
                .filter(p -> p.getCPF().equals(cpfPaciente))
                .findFirst()
                .orElse(null);

        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado. Operação cancelada.");
            return;
        }

        System.out.println("Selecione o médico pelo CRM:");
        for (Medico m : medicos) {
            System.out.println("Nome: " + m.getNome() + " | CRM: " + m.getCrm());
        }
        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.next();
        Medico medicoSelecionado = medicos.stream()
                .filter(m -> m.getCrm().equals(crmMedico))
                .findFirst()
                .orElse(null);

        if (medicoSelecionado == null) {
            System.out.println("Médico não encontrado. Operação cancelada.");
            return;
        }

        System.out.print("Digite os medicamentos prescritos: ");
        scanner.nextLine();
        String medicamentos = scanner.nextLine();

        System.out.print("Digite as observações do receituário: ");
        String observacoes = scanner.nextLine();

        LocalDate dataCriacao = LocalDate.now();

        Receituario receituario = new Receituario(idReceituario, pacienteSelecionado, medicoSelecionado, dataCriacao, medicamentos, observacoes);
        receituarios.add(receituario);

        System.out.println("Receituário criado com sucesso! ID: " + idReceituario);
    }

    public void alterarReceituario() {
        System.out.print("Digite o ID do receituário a ser alterado: ");
        String id = scanner.next();

        Receituario receituarioEncontrado = receituarios.stream()
                .filter(r -> r.getIdReceituario().equals(id))
                .findFirst()
                .orElse(null);

        if (receituarioEncontrado != null) {
            System.out.println("Receituário encontrado!");
            System.out.println("Medicamentos atuais: " + receituarioEncontrado.getMedicamentos());
            System.out.println("Observações atuais: " + receituarioEncontrado.getObservacoes());

            System.out.print("Digite os novos medicamentos (ou pressione Enter para manter): ");
            scanner.nextLine();
            String novosMedicamentos = scanner.nextLine();
            if (!novosMedicamentos.isEmpty()) {
                receituarioEncontrado.setMedicamentos(novosMedicamentos);
            }

            System.out.print("Digite as novas observações (ou pressione Enter para manter): ");
            String novasObservacoes = scanner.nextLine();
            if (!novasObservacoes.isEmpty()) {
                receituarioEncontrado.setObservacoes(novasObservacoes);
            }

            System.out.println("Receituário atualizado com sucesso!");
        } else {
            System.out.println("Receituário não encontrado.");
        }
    }

    public void removerReceituario() {
        System.out.print("Digite o ID do receituário a ser removido: ");
        String id = scanner.next();

        Receituario receituarioRemovido = receituarios.stream()
                .filter(r -> r.getIdReceituario().equals(id))
                .findFirst()
                .orElse(null);

        if (receituarioRemovido != null) {
            receituarios.remove(receituarioRemovido);
            System.out.println("Receituário removido com sucesso!");
        } else {
            System.out.println("Receituário não encontrado.");
        }
    }

    public void listarTodosReceituarios() {
        if (receituarios.isEmpty()) {
            System.out.println("Não há receituários cadastrados.");
        } else {
            System.out.println("Listando todos os receituários:");
            for (Receituario r : receituarios) {
                System.out.println("ID: " + r.getIdReceituario());
                System.out.println("Paciente: " + r.getPaciente().getNome() + " (CPF: " + r.getPaciente().getCPF() + ")");
                System.out.println("Médico: " + r.getMedico().getNome() + " (CRM: " + r.getMedico().getCrm() + ")");
                System.out.println("Medicamentos: " + r.getMedicamentos());
                System.out.println("Observações: " + r.getObservacoes());
                System.out.println("Data: " + r.getDataEmissao());
                System.out.println("---------------------------------");
            }
        }
    }
}
