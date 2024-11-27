package Interfaces;
import java.util.Scanner;


public interface IConsultaController {
    void agendarConsulta(Scanner scanner);
    void listarConsultas();
    void alterarConsulta(Scanner scanner);
    void cancelarConsulta(Scanner scanner);
}
