package com.contabancaria.contabancaria.controller;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import com.contabancaria.contabancaria.operacaoStrategy.EnumStrategyOperacao;
import com.contabancaria.contabancaria.operacaoStrategy.IOperacaoStrategy;
import com.contabancaria.contabancaria.operacaoStrategy.OperacaoFactory;
import com.contabancaria.contabancaria.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping(value ="/contabancaria")
public class ContaBancariaController {

    private final ContaBancariaService contaBancariaService;

    private final OperacaoFactory operacaoFactory;
    @Autowired
    public ContaBancariaController(ContaBancariaService contaBancariaService, OperacaoFactory operacaoFactory) {
        this.contaBancariaService = contaBancariaService;
        this.operacaoFactory = operacaoFactory;
    }
    @GetMapping
    public Iterable<ContaBancariaDTO> listaContaBancarias() {

        return contaBancariaService.listaContasBancarias();
    }
    @GetMapping(value = "/{id}")
    public Optional<ContaBancariaDTO> getContaBancariaById(@PathVariable Long id) {
        return contaBancariaService.getContaBancariaById(id);
    }

    @PostMapping
    public ContaBancariaDTO novaContaBancaria(@RequestBody ContaBancariaDTO contaBancariaDTO){
        return contaBancariaService.criaContaBancaria(contaBancariaDTO);
    }
    @DeleteMapping(path = "/{id}")
    public void deletaContaBancaria(@PathVariable Long id){
        contaBancariaService.deletaContaBancaria(id);
    }

    @PostMapping("/{id}/operacao")
    public ContaBancariaDTO realizaOperacao (
                                                @PathVariable Long id,
                                                @RequestParam String operacao,
                                                @RequestParam BigDecimal valor){
      ContaBancariaDTO contaBancariaDTO = contaBancariaService.realizarOperacao(id,operacao,valor);
        return contaBancariaDTO;
    }


}
