package com.contabancaria.contabancaria.dto;

import com.contabancaria.contabancaria.model.Cliente;
import com.contabancaria.contabancaria.model.ContaBancaria;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ClienteDTO {

    private static final long serialVersionUID = 1L;

    private Long idCliente;
    private String nomeCliente;
    private List<ContaBancaria> contaBancaria;

    public ClienteDTO(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCliente = cliente.getNomeCliente();
        this.contaBancaria = cliente.getContaBancaria();
    }


    public Cliente toClientes(){
        return new Cliente(idCliente,nomeCliente,contaBancaria);
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<ContaBancaria> getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(List<ContaBancaria> contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
}
