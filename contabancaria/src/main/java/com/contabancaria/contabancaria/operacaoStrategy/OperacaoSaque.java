package com.contabancaria.contabancaria.operacaoStrategy;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import com.contabancaria.contabancaria.model.ContaBancaria;

import java.math.BigDecimal;

public class OperacaoSaque implements IOperacaoStrategy {


    @Override
    public BigDecimal operacao(BigDecimal valor, ContaBancariaDTO contaBancariaDTO) {
        BigDecimal resultadoFinal;
        resultadoFinal = contaBancariaDTO.getSaldoAtual().subtract(valor);
        contaBancariaDTO.setSaldoFinal(resultadoFinal);
        return resultadoFinal;
    }

    @Override
    public EnumStrategyOperacao getOperacaoStrategy() {
        return EnumStrategyOperacao.SAQUE;
    }
}
