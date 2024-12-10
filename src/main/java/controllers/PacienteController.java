package controllers;

import Interfaces.IPacienteController;
import models.Paciente;
import repositories.PacienteRepository;
import java.util.List;
import java.util.Scanner;

public class PacienteController implements IPacienteController {

    private final PacienteRepository pacienteRepository = new PacienteRepository();
    private final Scanner input = new Scanner(System.in);
    private List<Paciente> pacientesCache;

    public PacienteController() {
        this.pacientesCache = pacienteRepository.findAll();
    }

    @Override
    public void criarPaciente() {
        System.out.print("Digite o CPF do paciente: ");
        String CPF = input.next();

        System.out.print("Digite o nome do paciente: ");
        String nome = input.next();

        System.out.print("Digite a idade do paciente: ");
        String idade = input.next();

        Paciente paciente = new Paciente(CPF, nome, idade);

        pacienteRepository.save(paciente);
        pacientesCache.add(paciente);
        System.out.println("Paciente criado com sucesso!");
    }

    @Override
    public void alterarPaciente() {
        System.out.print("Digite o ID do paciente a ser alterado: ");
        int id = input.nextInt();

        Paciente paciente = pacienteRepository.findById(id);

        if (paciente != null) {
            System.out.println("Paciente encontrado: ");
            System.out.println("Nome atual: " + paciente.getNome());
            System.out.println("Idade atual: " + paciente.getIdade());
            System.out.println("CPF atual: " + paciente.getCPF());

            System.out.print("Digite o novo nome (ou pressione Enter para manter o atual): ");
            input.nextLine();
            String novoNome = input.nextLine();
            if (!novoNome.isEmpty()) {
                paciente.setNome(novoNome);
            }

            System.out.print("Digite a nova idade (ou pressione Enter para manter a atual): ");
            String novaIdade = input.nextLine();
            if (!novaIdade.isEmpty()) {
                paciente.setIdade(novaIdade);
            }

            System.out.print("Digite o novo CPF (ou pressione Enter para manter o atual): ");
            String novoCpf = input.nextLine();
            if (!novoCpf.isEmpty()) {
                paciente.setCPF(novoCpf);
            }

            pacienteRepository.save(paciente);
            pacientesCache = pacienteRepository.findAll();
            System.out.println("Paciente atualizado com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    @Override
    public void removerPaciente() {
        System.out.print("Digite o Id do paciente a remover: ");
        int id = input.nextInt();

        Paciente paciente = pacienteRepository.findById(id);
        if (paciente != null) {
            pacienteRepository.remove(paciente);
            pacientesCache.remove(paciente);
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    @Override
    public List<Paciente> listarTodosPacientes() {
        pacientesCache = pacienteRepository.findAll();
        for (Paciente paciente : pacientesCache) {
            paciente.exibirPaciente();
        }
        return pacientesCache;
    }

    public void buscarPacientePorId() {
        System.out.println("Digite o Id do paciente: ");
        int id = input.nextInt();
        Paciente paciente = pacienteRepository.findById(id);
        if (paciente != null) {
            paciente.exibirPaciente();
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public List<Paciente> getPacientes() {
        if (pacientesCache.isEmpty()) {
            pacientesCache = pacienteRepository.findAll();
        }
        return pacientesCache;
    }
}
