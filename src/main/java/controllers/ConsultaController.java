package controllers;

import Interfaces.IConsultaController;
import models.Consulta;
import models.Paciente;
import models.Medico;
import repositories.ConsultaRepository;
import utils.DataUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class ConsultaController implements IConsultaController {

    private List<Consulta> cacheConsultas = new ArrayList<>();
    private final List<Paciente> cachePacientes;
    private final List<Medico> cacheMedicos;

    private final PacienteController pc = new PacienteController();
    private final MedicoController mc = new MedicoController();

    private final ConsultaRepository cr = new ConsultaRepository();

    public ConsultaController(List<Paciente> pacientes, List<Medico> medicos) {
        this.cachePacientes = pacientes;
        this.cacheMedicos = medicos;
    }

    public void agendarConsulta(Scanner scanner) {
        System.out.println("===== Agendar Consulta =====");

        pc.listarTodosPacientes();
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.next();
        Paciente pacienteSelecionado = null;

        for (Paciente paciente : cachePacientes) {
            if (paciente.getCPF().equals(cpfPaciente)) {
                pacienteSelecionado = paciente;
                break;
            }
        }

        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        mc.listarTodosMedicos();
        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.next();
        Medico medicoSelecionado = null;

        for (Medico medico : cacheMedicos) {
            if (medico.getCrm().equals(crmMedico)) {
                medicoSelecionado = medico;
                break;
            }
        }

        if (medicoSelecionado == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Digite a data da consulta (dd/MM/yyyy): ");
        String dataStr = scanner.next();
        Date dataConsulta = DataUtil.stringToDate(dataStr);

        if (dataConsulta == null) {
            System.out.println("Data inválida! A consulta não pode ser agendada.");
            return;
        }

        System.out.print("Digite a hora da consulta (hh:mm): ");
        String horaStr = scanner.next();
        String[] horaParts = horaStr.split(":");
        if (horaParts.length == 2) {
            int hora = Integer.parseInt(horaParts[0]);
            int minuto = Integer.parseInt(horaParts[1]);

            dataConsulta.setHours(hora);
            dataConsulta.setMinutes(minuto);
        } else {
            System.out.println("Hora inválida. A consulta será agendada sem hora específica.");
        }

        System.out.print("Digite a descrição da consulta: ");
        scanner.nextLine();
        String descricao = scanner.nextLine();

        System.out.print("Digite o valor da consulta: R$ ");
        double valor = scanner.nextDouble();

        Consulta novaConsulta = new Consulta(0, pacienteSelecionado, medicoSelecionado, dataConsulta, descricao, valor);

        cr.save(novaConsulta);
        cacheConsultas.add(novaConsulta);

        System.out.println("Consulta agendada com sucesso!");
    }

    public List<Consulta> listarConsultas() {
        cacheConsultas = cr.findAll();
        if (cacheConsultas.isEmpty()) {
            System.out.println("Não há consultas agendadas.");
        } else {
            System.out.println("===== Consultas Agendadas =====");
            for (Consulta consulta : cacheConsultas) {
                consulta.exibirConsulta();
            }
        }
        return cacheConsultas;
    }

    @Override
    public void cancelarConsulta(Scanner scanner) {
        System.out.println("===== Cancelar Consulta =====");
        listarConsultas();

        System.out.print("Digite o ID da consulta a ser cancelada: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido para o ID da consulta.");
            scanner.next();
            System.out.print("Digite o ID da consulta a ser cancelada: ");
        }
        int idConsulta = scanner.nextInt();

        boolean consultaCancelada = false;
        for (Consulta consulta : cacheConsultas) {
            if (consulta.getId() == idConsulta) {
                cr.delete(idConsulta);
                cacheConsultas.remove(consulta);
                consultaCancelada = true;
                System.out.println("Consulta cancelada com sucesso!");
                break;
            }
        }

        if (!consultaCancelada) {
            System.out.println("Consulta não encontrada.");
        }
    }

    public void alterarConsulta(Scanner scanner) {
        System.out.println("===== Alterar Consulta =====");
        listarConsultas();

        System.out.print("Digite o ID da consulta a ser alterada: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido para o ID da consulta.");
            scanner.next();
            System.out.print("Digite o ID da consulta a ser alterada: ");
        }
        int idConsulta = scanner.nextInt();

        Consulta consulta = cacheConsultas.stream()
                .filter(c -> c.getId() == idConsulta)
                .findFirst()
                .orElse(null);

        if (consulta == null) {
            System.out.println("Consulta não encontrada.");
            return;
        }

        System.out.println("Consulta encontrada. Vamos alterar os dados.");

        System.out.print("Digite a nova data da consulta (dd/MM/yyyy): ");
        String dataStr = scanner.next();
        Date novaData = DataUtil.stringToDate(dataStr);
        if (novaData == null) {
            System.out.println("Data inválida! A consulta não pode ser alterada.");
            return;
        }

        System.out.print("Digite a nova hora da consulta (hh:mm): ");
        String horaStr = scanner.next();
        String[] horaParts = horaStr.split(":");
        if (horaParts.length == 2) {
            int hora = Integer.parseInt(horaParts[0]);
            int minuto = Integer.parseInt(horaParts[1]);
            novaData.setHours(hora);
            novaData.setMinutes(minuto);
        }

        System.out.print("Digite a nova descrição da consulta: ");
        scanner.nextLine();
        String novaDescricao = scanner.nextLine();

        System.out.print("Digite o novo valor da consulta: R$ ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, insira um valor válido para o novo valor da consulta.");
            scanner.next();
            System.out.print("Digite o novo valor da consulta: R$ ");
        }
        double novoValor = scanner.nextDouble();

        consulta.setDataConsulta(novaData);
        consulta.setDescricao(novaDescricao);
        consulta.setValor(novoValor);

        cr.update(consulta);

        System.out.println("Consulta alterada com sucesso!");
    }
}
