package com.contabancaria.contabancaria;

import com.contabancaria.contabancaria.operacaoStrategy.IOperacaoStrategy;
import com.contabancaria.contabancaria.operacaoStrategy.OperacaoFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContabancariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContabancariaApplication.class, args);
	}



}
