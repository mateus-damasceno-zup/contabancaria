package com.contabancaria.contabancaria.operacaoStrategy;

import java.math.BigDecimal;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import com.contabancaria.contabancaria.model.ContaBancaria;

public class OperacaoDeposito implements IOperacaoStrategy {

    @Override
    public BigDecimal operacao(BigDecimal valor, ContaBancariaDTO contaBancariaDTO) {
        BigDecimal resultadoFinal;
        resultadoFinal = valor.add(contaBancariaDTO.getSaldoAtual());
        contaBancariaDTO.setSaldoFinal(resultadoFinal);
        return resultadoFinal;
    }

    public EnumStrategyOperacao getOperacaoStrategy() {
        return EnumStrategyOperacao.DEPOSITO;
    }
}
