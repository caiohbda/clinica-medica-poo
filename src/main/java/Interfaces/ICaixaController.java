package Interfaces;

public interface ICaixaController {
    void registrarEntrada(double valor, String descricao, String formaPagamento);
    void registrarSaida(double valor, String descricao, String formaPagamento);
    void exibirExtrato();
}
