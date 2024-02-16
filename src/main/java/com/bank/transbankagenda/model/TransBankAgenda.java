package com.bank.transbankagenda.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "bank")
public class TransBankAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String ContaOrigem;
    private String ContaDestino;
    private double Valor;
    private double Saldo;
    private double Taxa;
    private LocalDateTime DataAtual;
    private LocalDateTime DataTransferencia;
    private double ValorAgendadoTransferencia;
}

