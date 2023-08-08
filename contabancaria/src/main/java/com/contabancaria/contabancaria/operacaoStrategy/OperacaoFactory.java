package com.contabancaria.contabancaria.operacaoStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;



@Component
public class OperacaoFactory {

    private Map<EnumStrategyOperacao, IOperacaoStrategy> operacao;

    @Autowired
    public OperacaoFactory(Set<IOperacaoStrategy> operacaoSet) {
       criaOperacao(operacaoSet);
    }

    public IOperacaoStrategy encontrarEstrategia(EnumStrategyOperacao enumStrategyOperacao){
        return operacao.get(enumStrategyOperacao);
    }

    private void criaOperacao(Set<IOperacaoStrategy> estrategiaSet){
        operacao = new HashMap<EnumStrategyOperacao, IOperacaoStrategy>();
        estrategiaSet.forEach(
                estrategia -> operacao.put(estrategia.getOperacaoStrategy(),estrategia));
    }
}
