package com.contabancaria.contabancaria.operacaoStrategy;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;

import java.math.BigDecimal;

public interface IOperacaoStrategy {

    BigDecimal operacao(BigDecimal valor, ContaBancariaDTO contaBancariaDTO);
    EnumStrategyOperacao getOperacaoStrategy();
}
