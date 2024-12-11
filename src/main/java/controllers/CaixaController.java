package controllers;

import Interfaces.ICaixaController;
import models.Caixa;
import repositories.CaixaRepository;
import java.util.List;

public class CaixaController implements ICaixaController {
    private final CaixaRepository caixaRepository;
    private double saldo;

    public CaixaController() {
        this.caixaRepository = new CaixaRepository();
        this.saldo = calcularSaldo();
    }

    @Override
    public void registrarEntrada(double valor, String descricao, String formaPagamento) {
        if (valor > 0) {
            Caixa entrada = new Caixa(0, "Entrada", valor, new java.util.Date(), descricao, formaPagamento);
            caixaRepository.save(entrada);
            saldo += valor;
            System.out.println("Entrada registrada: R$ " + valor);
        } else {
            System.out.println("Valor inválido para entrada.");
        }
    }

    @Override
    public void registrarSaida(double valor, String descricao, String formaPagamento) {
        if (valor > 0 && valor <= saldo) {
            Caixa saida = new Caixa(0, "Saída", valor, new java.util.Date(), descricao, formaPagamento);
            caixaRepository.save(saida);
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
        List<Caixa> movimentacoes = caixaRepository.findAll();
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

    private double calcularSaldo() {
        List<Caixa> movimentacoes = caixaRepository.findAll();
        double saldoCalculado = 0;
        for (Caixa movimentacao : movimentacoes) {
            if ("Entrada".equals(movimentacao.getTipo())) {
                saldoCalculado += movimentacao.getValor();
            } else {
                saldoCalculado -= movimentacao.getValor();
            }
        }
        return saldoCalculado;
    }
}
