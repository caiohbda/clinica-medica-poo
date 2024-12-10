package Interfaces;
import models.Consulta;

import java.util.List;
import java.util.Scanner;


public interface IConsultaController {
    void agendarConsulta(Scanner scanner);
    List<Consulta> listarConsultas();
    void alterarConsulta(Scanner scanner);
    void cancelarConsulta(Scanner scanner);
}
