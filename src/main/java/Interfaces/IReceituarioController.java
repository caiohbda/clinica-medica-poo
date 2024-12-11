package Interfaces;

import models.Receituario;

import java.util.List;
import java.util.Scanner;

public interface IReceituarioController {
    void criarReceituario(Scanner scanner);
    void alterarReceituario(Scanner scanner);
    void removerReceituario(Scanner scanner);
    List<Receituario> listarReceituarios();


}
