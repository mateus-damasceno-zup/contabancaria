package com.contabancaria.contabancaria.operacaoStrategy;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import com.contabancaria.contabancaria.model.ContaBancaria;

import java.math.BigDecimal;

public interface IOperacaoStrategy {
    ContaBancaria realizaOperacao(BigDecimal valor, ContaBancaria contaBancaria);

}
