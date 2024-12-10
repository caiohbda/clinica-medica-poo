package Interfaces;

import java.util.List;

public interface IPacienteController {
    void criarPaciente();
    void alterarPaciente();
    List listarTodosPacientes();
    void removerPaciente();
    void buscarPacientePorId();
}
