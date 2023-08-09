package com.contabancaria.contabancaria.model;
import com.contabancaria.contabancaria.dto.ContaBancariaDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;
    private int numeroConta;
    private int agencia;
    private BigDecimal saldoAtual;
    private BigDecimal saldoFinal;
    private BigDecimal valorOperacao;

    private String tipoOperacao;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public ContaBancaria(Long idConta, int numeroConta, int agencia, BigDecimal saldoAtual, BigDecimal saldoFinal, BigDecimal valorOperacao, String tipoOperacao) {
        this.idConta = idConta;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldoAtual = saldoAtual;
        this.saldoFinal = saldoFinal;
        this.valorOperacao = valorOperacao;
        this.tipoOperacao = tipoOperacao;
    }
    public ContaBancaria(ContaBancariaDTO contaBancariaDTO) {
         this(contaBancariaDTO.getIdConta(), contaBancariaDTO.getNumeroConta(), contaBancariaDTO.getAgencia(),contaBancariaDTO.getSaldoAtual(),
                contaBancariaDTO.getSaldoFinal(),contaBancariaDTO.getValorOperacao(),contaBancariaDTO.getTipoOperacao());
    }
}
