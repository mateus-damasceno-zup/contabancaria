package com.contabancaria.contabancaria.operacaoStrategy;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import com.contabancaria.contabancaria.model.ContaBancaria;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class OperacaoSaque implements IOperacaoStrategy {
    @Override
    public ContaBancaria realizaOperacao(BigDecimal valor, ContaBancaria contaBancaria) {
        contaBancaria.setSaldo(contaBancaria.getSaldo()-valor);

        return contaBancaria;
    }
}
