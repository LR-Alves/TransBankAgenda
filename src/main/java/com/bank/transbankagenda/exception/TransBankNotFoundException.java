package com.bank.transbankagenda.exception;

public class TransBankNotFoundException extends RuntimeException {


    public TransBankNotFoundException(Long id) {
        super("transferencia  com ID " + id + " não encontrada");
    }
}
