package com.contabancaria.contabancaria.dto;

import com.contabancaria.contabancaria.model.Cliente;
import com.contabancaria.contabancaria.model.ContaBancaria;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
public class ContaBancariaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idConta;
    private int numeroConta;
    private int agencia;
    private BigDecimal saldoAtual;
    private BigDecimal saldoFinal;
    private BigDecimal valorOperacao;
    private String tipoOperacao;


    public ContaBancariaDTO(ContaBancaria contaBancaria) {
        this.idConta= contaBancaria.getIdConta();
        this.numeroConta = contaBancaria.getNumeroConta();
        this.agencia = contaBancaria.getAgencia();
        this.saldoAtual = contaBancaria.getSaldoAtual();
        this.saldoFinal = contaBancaria.getSaldoFinal();
        this.valorOperacao = contaBancaria.getValorOperacao();
        this.tipoOperacao = contaBancaria.getTipoOperacao();

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


}
