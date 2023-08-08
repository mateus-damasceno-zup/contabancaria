package com.contabancaria.contabancaria.service;

import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import com.contabancaria.contabancaria.model.ContaBancaria;
import com.contabancaria.contabancaria.repository.ContaBancariaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaBancariaService {

    private final ContaBancariaRepository contaBancariaRepository;

    public ContaBancariaService(ContaBancariaRepository contaBancariaRepository) {
        this.contaBancariaRepository = contaBancariaRepository;
    }

    public ContaBancariaDTO criaContaBancaria(ContaBancariaDTO contaBancariaDTO){
        ContaBancaria savedConta = contaBancariaRepository.save(contaBancariaDTO.toContaBancaria());
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

    public ContaBancariaDTO atualizaConaBancaria(Long id,ContaBancariaDTO contaBancariaDTO) {
        ContaBancaria contaBancaria = contaBancariaRepository.findById(id).get();
        //todo: adicionar verificacao se nao existir e estourar um erro. como estourar um erro no spring
        contaBancaria.setIdConta(contaBancariaDTO.getIdConta());
        contaBancaria.setNumeroConta(contaBancariaDTO.getNumeroConta());
        contaBancaria.setAgencia(contaBancariaDTO.getAgencia());
        contaBancaria.setSaldoAtual(contaBancariaDTO.getSaldoAtual());
        contaBancaria.setSaldoFinal(contaBancariaDTO.getSaldoFinal());
        contaBancaria.setTipoOperacao(contaBancariaDTO.getTipoOperacao());
        contaBancaria.setCliente(contaBancariaDTO.getClientes());

        ContaBancaria contaBancariaAtualizada = contaBancariaRepository.save(contaBancaria);

        return new ContaBancariaDTO(contaBancariaAtualizada);
    }
    public void deletaContaBancaria(Long id) {
        contaBancariaRepository.deleteById(id);
    }

}
