package controllers;

import Interfaces.ICaixaController;
import models.Caixa;
import java.util.ArrayList;
import java.util.List;

public class CaixaController implements ICaixaController {
    private final List<Caixa> movimentacoes = new ArrayList<>();
    private double saldo;

    public CaixaController() {
        this.saldo = 0.0;
    }

    @Override
    public void registrarEntrada(double valor, String descricao, String formaPagamento) {
        if (valor > 0) {
            Caixa entrada = new Caixa(movimentacoes.size() + 1, "Entrada", valor, new java.util.Date(), descricao, formaPagamento);
            movimentacoes.add(entrada);
            saldo += valor;
            System.out.println("Entrada registrada: R$ " + valor);
        } else {
            System.out.println("Valor inválido para entrada.");
        }
    }

    @Override
    public void registrarSaida(double valor, String descricao, String formaPagamento) {
        if (valor > 0 && valor <= saldo) {
            Caixa saida = new Caixa(movimentacoes.size() + 1, "Saída", valor, new java.util.Date(), descricao, formaPagamento);
            movimentacoes.add(saida);
            saldo -= valor;
            System.out.println("Saída registrada: R$ " + valor);
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar essa saída.");
        } else {
            System.out.println("Valor inválido para saída.");
        }
    }

    @Override
    public void exibirExtrato() {
        if (movimentacoes.isEmpty()) {
            System.out.println("Não há movimentações registradas.");
        } else {
            System.out.println("===== EXTRATO =====");
            for (Caixa movimentacao : movimentacoes) {
                movimentacao.exibirMovimentacao();
            }
            System.out.println("Saldo atual: R$ " + saldo);
        }
    }
}
