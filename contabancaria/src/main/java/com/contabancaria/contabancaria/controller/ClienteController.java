package com.contabancaria.contabancaria.controller;

import com.contabancaria.contabancaria.dto.ClienteDTO;
import com.contabancaria.contabancaria.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Iterable<ClienteDTO> listaClientes() {

        return clienteService.listClientes();
    }

    @GetMapping(value = "/{id}")
    public Optional<ClienteDTO> getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public ClienteDTO novoCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.criarCliente(clienteDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deletaBebida(@PathVariable Long id) {
        clienteService.deletaCliente(id);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizaBebida(@PathVariable Long id,
                                     @RequestBody ClienteDTO clienteDTO) {
        return clienteService.atualizaCliente(id, clienteDTO);
    }
}
