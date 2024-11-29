package controllers;

import Interfaces.IConsultaController;
import models.Consulta;
import models.Paciente;
import models.Medico;
import utils.DataUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsultaController implements IConsultaController {

    private final List<Consulta> consultas = new ArrayList<>();
    private final List<Paciente> pacientes;
    private final List<Medico> medicos;

    public ConsultaController(List<Paciente> pacientes, List<Medico> medicos) {
        this.pacientes = pacientes;
        this.medicos = medicos;
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes cadastrados.");
        } else {
            System.out.println("===== Pacientes Cadastrados =====");
            for (Paciente paciente : pacientes) {
                System.out.println("Nome: " + paciente.getNome() + " | CPF: " + paciente.getCPF());
            }
        }
    }

    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Não há médicos cadastrados.");
        } else {
            System.out.println("===== Médicos Cadastrados =====");
            for (Medico medico : medicos) {
                System.out.println("Nome: " + medico.getNome() + " | CRM: " + medico.getCrm());
            }
        }
    }

    public void agendarConsulta(Scanner scanner) {
        System.out.println("===== Agendar Consulta =====");
        listarPacientes();
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.next();
        Paciente pacienteSelecionado = null;
        for (Paciente paciente : pacientes) {
            if (paciente.getCPF().equals(cpfPaciente)) {
                pacienteSelecionado = paciente;
                break;
            }
        }

        if (pacienteSelecionado == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        listarMedicos();
        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.next();
        Medico medicoSelecionado = null;
        for (Medico medico : medicos) {
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

        int consultaId = consultas.size() + 1;
        Consulta novaConsulta = new Consulta(consultaId, pacienteSelecionado, medicoSelecionado, dataConsulta, descricao, valor);
        consultas.add(novaConsulta);

        System.out.println("Consulta agendada com sucesso!");
    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas agendadas.");
        } else {
            System.out.println("===== Consultas Agendadas =====");
            for (Consulta consulta : consultas) {
                consulta.exibirConsulta();
            }
        }
    }

    @Override
    public void cancelarConsulta(Scanner scanner) {
        System.out.println("===== Cancelar Consulta =====");
        listarConsultas();
        System.out.print("Digite o ID da consulta a ser cancelada: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido para o ID da consulta.");
            scanner.next();  // Limpar a entrada inválida
            System.out.print("Digite o ID da consulta a ser cancelada: ");
        }
        int idConsulta = scanner.nextInt();

        boolean consultaCancelada = false;
        for (Consulta consulta : consultas) {
            if (consulta.getId() == idConsulta) {
                consultas.remove(consulta);
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

        boolean consultaEncontrada = false;
        for (Consulta consulta : consultas) {
            if (consulta.getId() == idConsulta) {
                consultaEncontrada = true;

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
                } else {
                    System.out.println("Hora inválida. A consulta será alterada sem hora específica.");
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

                System.out.println("Consulta alterada com sucesso!");
                break;
            }
        }

        if (!consultaEncontrada) {
            System.out.println("Consulta não encontrada.");
        }
    }

}
