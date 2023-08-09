package com.contabancaria.contabancaria.operacaoStrategy;

import java.math.BigDecimal;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import com.contabancaria.contabancaria.model.ContaBancaria;
import org.springframework.stereotype.Component;

@Component
public class OperacaoDeposito implements IOperacaoStrategy {
    @Override
    public ContaBancaria realizaOperacao(BigDecimal valor, ContaBancaria contaBancaria) {

        return contaBancaria;
    }
}
