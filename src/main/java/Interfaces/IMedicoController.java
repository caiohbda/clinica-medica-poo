package Interfaces;

import java.util.List;

public interface IMedicoController {
    void criarMedico();
    void alterarMedico();
    List listarTodosMedicos();
    void removerMedico();
    void buscarMedicoPorId();
}
