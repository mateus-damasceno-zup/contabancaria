package com.contabancaria.contabancaria.operacaoStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;



@Component
public class OperacaoFactory {
    public static IOperacaoStrategy getEstrategia(String tipoEstrategia){
        if ("saque".equalsIgnoreCase(tipoEstrategia)){
            return new OperacaoSaque();
        }else if("deposito".equalsIgnoreCase(tipoEstrategia)){
            return new OperacaoDeposito();
        }
    throw new IllegalArgumentException("operacao invalida "+ tipoEstrategia);
    }



}
