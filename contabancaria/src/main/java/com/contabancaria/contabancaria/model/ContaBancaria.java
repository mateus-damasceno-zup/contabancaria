package com.contabancaria.contabancaria.model;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class ContaBancaria {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idConta;
private int numeroConta;
private int agencia;
private BigDecimal saldoAtual;
private BigDecimal saldoFinal;
private BigDecimal valorOperacao;

private String tipoOperacao;
@ManyToOne
@JoinColumn(name = "cliente_id")
private Cliente cliente;

    public ContaBancaria(Long idConta, int numeroConta, int agencia, BigDecimal saldoAtual, BigDecimal saldoFinal, BigDecimal valorOperacao, String tipoOperacao, Cliente cliente) {
        this.idConta = idConta;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldoAtual = saldoAtual;
        this.saldoFinal = saldoFinal;
        this.valorOperacao = valorOperacao;
        this.tipoOperacao = tipoOperacao;
        this.cliente = cliente;
    }



    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(BigDecimal saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public BigDecimal getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(BigDecimal valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
