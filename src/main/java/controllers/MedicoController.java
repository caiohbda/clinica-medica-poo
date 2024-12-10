package controllers;

import repositories.MedicoRepository;
import models.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicoController {
    private final MedicoRepository medicoRepository = new MedicoRepository();
    private List<Medico> medicosCache = new ArrayList<>();
    private final Scanner input = new Scanner(System.in);

    public void criarMedico() {
        System.out.print("Digite o CRM do médico: ");
        String crm = input.next();

        System.out.print("Digite o nome do médico: ");
        String nome = input.next();

        System.out.print("Digite a especialidade do médico: ");
        String especialidade = input.next();

        System.out.print("Digite a idade do médico: ");
        String idade = input.next();

        Medico medico = new Medico(crm, nome, especialidade, idade);
        medicoRepository.save(medico);

        System.out.println("Médico criado com sucesso!");
    }

    public void alterarMedico() {
        System.out.print("Digite o ID do Médico a ser alterado: ");
        int id = input.nextInt();

        Medico medico = medicoRepository.findById(id);

        if (medico != null) {
            System.out.println("Médico encontrado: ");
            medico.exibirMedico();

            System.out.print("Digite o novo nome (ou pressione Enter para manter o atual): ");
            input.nextLine();
            String novoNome = input.nextLine();
            if (!novoNome.isEmpty()) {
                medico.setNome(novoNome);
            }

            System.out.print("Digite a nova idade (ou pressione Enter para manter a atual): ");
            String novaIdade = input.nextLine();
            if (!novaIdade.isEmpty()) {
                medico.setIdade(novaIdade);
            }

            System.out.print("Digite o novo CRM (ou pressione Enter para manter o atual): ");
            String novoCRM = input.nextLine();
            if (!novoCRM.isEmpty()) {
                medico.setCrm(novoCRM);
            }

            System.out.println("Digite a nova Especialidade (ou pressione Enter para manter o atual): ");
            String novaEspecialidade = input.nextLine();
            if (!novaEspecialidade.isEmpty()) {
                medico.setEspecialidade(novaEspecialidade);
            }

            medicoRepository.update(medico);

            System.out.println("Médico atualizado com sucesso!");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    public void removerMedico() {
        System.out.print("Digite o Id do médico a remover: ");
        String Id = input.next();
        Medico medico = medicoRepository.findById(Integer.parseInt(Id));

        if (medico != null) {
            medicoRepository.delete(Integer.parseInt(Id));
            System.out.println("Médico removido com sucesso!");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    public List<Medico> listarTodosMedicos() {
        medicosCache = medicoRepository.findAll();
        for (Medico medico : medicosCache) {
            medico.exibirMedico();
        }
        return medicosCache;
    }

    public void buscarMedicoPorId() {
        System.out.print("Digite o Id do Médico: ");
        int id = input.nextInt();
        Medico medico = medicoRepository.findById(id);

        if (medico != null) {
            medico.exibirMedico();
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    public List<Medico> getMedicos() {
        if (medicosCache.isEmpty()) {
            medicosCache = medicoRepository.findAll();
        }
        return medicosCache;
    }
}
