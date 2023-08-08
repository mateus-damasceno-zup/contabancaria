package com.contabancaria.contabancaria.service;

import com.contabancaria.contabancaria.dto.ClienteDTO;
import com.contabancaria.contabancaria.model.Cliente;
import com.contabancaria.contabancaria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public ClienteDTO criarCliente(ClienteDTO cliente) {
        Cliente savedCliente = clienteRepository.save(cliente.toClientes());
        return new ClienteDTO(savedCliente);
    }

    public Optional<ClienteDTO> getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent())
            return Optional.of(new ClienteDTO(cliente.get()));
        return Optional.empty();
    }

    public Iterable<ClienteDTO> listClientes() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clienteDTOList = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clienteDTOList.add(new ClienteDTO(cliente));
        }

        return clienteDTOList;
    }
    public ClienteDTO atualizaCliente(Long id,ClienteDTO clienteDTO) {
        Cliente clienteAtual = clienteRepository.findById(id).get();
        //todo: adicionar verificacao se nao existir e estourar um erro. como estourar um erro no spring
        clienteAtual.setNomeCliente(clienteDTO.getNomeCliente());
        Cliente clienteAtualizado = clienteRepository.save(clienteAtual);

        return new ClienteDTO((clienteAtualizado));

    }

    public void deletaCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
