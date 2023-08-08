package com.contabancaria.contabancaria.dto;

import com.contabancaria.contabancaria.model.Cliente;
import com.contabancaria.contabancaria.model.ContaBancaria;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class ClienteDTO {

    private static final long serialVersionUID = 1L;

    private Long idCLiente;
    private String nomeCliente;
    private List<ContaBancaria> contaBancaria;

    public ClienteDTO(Cliente cliente) {
        this.idCLiente = cliente.getIdCLiente();
        this.nomeCliente = cliente.getNomeCliente();
        this.contaBancaria = cliente.getContaBancaria();
    }

    public ClienteDTO() {
    }

    public Cliente toClientes(){
        return new Cliente(idCLiente,nomeCliente,contaBancaria);
    }

    public Long getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(Long idCLiente) {
        this.idCLiente = idCLiente;
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
