package com.contabancaria.contabancaria.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCLiente;
    private String nomeCliente;
    @OneToMany (mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContaBancaria> contaBancaria;

    public Cliente(Long idCLiente, String nomeCliente, List<ContaBancaria> contaBancaria) {
        this.idCLiente = idCLiente;
        this.nomeCliente = nomeCliente;
        this.contaBancaria = contaBancaria;
    }

    public Cliente() {
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
