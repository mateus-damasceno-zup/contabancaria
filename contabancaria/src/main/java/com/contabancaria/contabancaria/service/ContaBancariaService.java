package com.contabancaria.contabancaria.service;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import com.contabancaria.contabancaria.model.ContaBancaria;
import com.contabancaria.contabancaria.operacaoStrategy.EnumStrategyOperacao;
import com.contabancaria.contabancaria.operacaoStrategy.IOperacaoStrategy;
import com.contabancaria.contabancaria.operacaoStrategy.OperacaoFactory;
import com.contabancaria.contabancaria.repository.ContaBancariaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {

    private final ContaBancariaRepository contaBancariaRepository;
    @Autowired
    private OperacaoFactory operacaoFactory;

    public ContaBancariaService(ContaBancariaRepository contaBancariaRepository) {
        this.contaBancariaRepository = contaBancariaRepository;
    }

    public ContaBancariaDTO criaContaBancaria(ContaBancariaDTO contaBancariaDTO){

        ContaBancaria savedConta = contaBancariaRepository.save(new ContaBancaria(contaBancariaDTO));
        return new ContaBancariaDTO(savedConta);
    }


    public Optional<ContaBancariaDTO> getContaBancariaById(Long id) {
        Optional<ContaBancaria> contaBancaria = contaBancariaRepository.findById(id);
        return contaBancaria.map(ContaBancariaDTO::new);
    }

    public Iterable<ContaBancariaDTO> listaContasBancarias() {
        Iterable<ContaBancaria> contaBancarias = contaBancariaRepository.findAll();
        List<ContaBancariaDTO> contaBancariaDTOTOList = new ArrayList<>();

        for (ContaBancaria contaBancaria : contaBancarias) {
            contaBancariaDTOTOList.add(new ContaBancariaDTO(contaBancaria));
        }
        return contaBancariaDTOTOList;
    }

    public ContaBancariaDTO atualizaContaBancaria(Long id,ContaBancariaDTO contaBancariaDTO) {
        ContaBancaria contaBancaria = contaBancariaRepository.findById(id).get();
        //todo: adicionar verificacao se nao existir e estourar um erro. como estourar um erro no spring
        contaBancaria.setIdConta(contaBancariaDTO.getIdConta());
        contaBancaria.setNumeroConta(contaBancariaDTO.getNumeroConta());
        contaBancaria.setAgencia(contaBancariaDTO.getAgencia());
        contaBancaria.setSaldoAtual(contaBancariaDTO.getSaldoAtual());
        contaBancaria.setSaldoFinal(contaBancariaDTO.getSaldoFinal());
        contaBancaria.setTipoOperacao(contaBancariaDTO.getTipoOperacao());


        ContaBancaria contaBancariaAtualizada = contaBancariaRepository.save(contaBancaria);

        return new ContaBancariaDTO(contaBancariaAtualizada);
    }
    public void deletaContaBancaria(Long id) {
        contaBancariaRepository.deleteById(id);
    }


    public ContaBancariaDTO realizarOperacao(Long id, String tipoOperacao, BigDecimal valorOperacao) {
        ContaBancaria contaBancaria = contaBancariaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta bancária não encontrada"));

        IOperacaoStrategy operacaoStrategy = OperacaoFactory.getEstrategia(tipoOperacao);
        ContaBancaria contaBancariaAtualizada = operacaoStrategy.realizaOperacao(valorOperacao,contaBancaria);

        // Atualizar a conta bancária no banco de dados
        ContaBancaria contaBancariaSalva = contaBancariaRepository.save(contaBancariaAtualizada);

        return new ContaBancariaDTO(contaBancariaSalva);
    }
}
