package com.contabancaria.contabancaria.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nomeCliente;
    @OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContaBancaria> contaBancaria;

    public Cliente(Long idCliente, String nomeCliente, List<ContaBancaria> contaBancaria) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.contaBancaria = contaBancaria;
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
