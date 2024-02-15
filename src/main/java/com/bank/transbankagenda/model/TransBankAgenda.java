package com.bank.transbankagenda.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bank")
public class TransBankAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String contaOrigem;
    private  String contaDestino;
    private double valor ;
    private double saldo ;
    private double taxa ;
    private LocalDateTime dataAtual ;
    private LocalDateTime dataTransferencia;
    private double valorAgendadoTransferencia;
}
