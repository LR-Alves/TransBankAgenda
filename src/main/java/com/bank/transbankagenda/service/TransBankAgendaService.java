package com.bank.transbankagenda.service;


import com.bank.transbankagenda.model.TransBankAgenda;
import com.bank.transbankagenda.repository.TransBankAgendaRepository;
import com.bank.transbankagenda.serviceImpl.TransBankAgendaServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransBankAgendaService {

    private final TransBankAgendaServiceImpl transBankAgendaService;

    public TransBankAgendaService(TransBankAgendaServiceImpl transBankAgendaService, EntityManager entityManager) {
        this.transBankAgendaService = transBankAgendaService;
    }

    private  TransBankAgendaRepository transBankAgendaRepository;

    @Autowired
    public TransBankAgendaService(TransBankAgendaServiceImpl transBankAgendaService, TransBankAgendaRepository transBankAgendaRepository) {
        this.transBankAgendaService = transBankAgendaService;
        this.transBankAgendaRepository = transBankAgendaRepository;
    }


    public void processarTransferencia(String numeroConta, double valor, LocalDateTime dataTransferencia) {
//        TransBankAgenda transBankAgenda = transBankAgendaRepository.findBy(numeroConta);
//        if (transBankAgenda == null) {
//            // Lidar com o caso em que a conta não é encontrada
//            return;
//        }
//        LocalDateTime dataAtual = LocalDateTime.now();
//        transBankAgendaService.subtrairValorDoSaldo(transBankAgenda, valor, dataAtual, dataTransferencia, valor);
//        transBankAgendaRepository.save(transBankAgenda);
    }


}

