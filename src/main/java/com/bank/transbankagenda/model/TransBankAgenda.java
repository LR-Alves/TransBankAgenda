package com.bank.transbankagenda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bank")
public class TransBankAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
