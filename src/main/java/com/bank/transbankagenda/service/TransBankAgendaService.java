package com.bank.transbankagenda.service;


import com.bank.transbankagenda.model.TransBankAgenda;
import com.bank.transbankagenda.repository.TransBankAgendaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransBankAgendaService {


    @PersistenceContext
    private EntityManager entityManager;

    public TransBankAgendaService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private  TransBankAgendaRepository transBankAgendaRepository;

//    public TransBankAgendService(TransBankAgendaRepository transBankAgendaRepository) {
//        this.transBankAgendaRepository = transBankAgendaRepository;
//    }
  

    @Transactional
    public void SalveUsuario(TransBankAgenda transBankAgenda){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            transBankAgendaRepository.save(transBankAgenda);

        }catch (Exception e ){
            throw new RuntimeException("error ao adicionar usuario");
        }
   }


//    @Transactional
//    public void processarTransferencia(String numeroConta, double valor, LocalDateTime dataTransferencia) {
//        TransBankAgenda transBankAgenda = transBankAgendaRepository.findByContaOrigem(numeroConta);
//        if (transBankAgenda == null) {
//            // Lidar com o caso em que a conta não é encontrada
//            return;
//        }
//
//        LocalDateTime dataAtual = LocalDateTime.now();
//        subtrairValorDoSaldo(transBankAgenda, valor, dataTransferencia, dataAtual);
//
//        transBankAgendaRepository.save(transBankAgenda);
//    }
//
//    private void subtrairValorDoSaldo(TransBankAgenda transBankAgenda, double valor, LocalDateTime dataAtual) {
//        double taxa = calcularTaxaTransferencia(dataAtual, transBankAgenda.getDataTransferencia(), valor);
//        double novoSaldo = transBankAgenda.getSaldo() - (valor + taxa);
//        transBankAgenda.setSaldo(novoSaldo);
//        transBankAgenda.setDataTransferencia(dataAtual); // Atualiza a data de transferência
//    }


//     Método para calcular a taxa de transferência com base nos dias de transferência
    public double calcularTaxaTransferencia(LocalDateTime dataAtual, LocalDateTime dataTransferencia, double valor) {
        double taxa = 0.0;

        if (dataTransferencia == null) {
            System.out.println("Data de transferência não especificada.");
            return taxa;
        }

        long diasTransferencia = ChronoUnit.DAYS.between(dataAtual.toLocalDate(), dataTransferencia.toLocalDate());

        if (diasTransferencia >= 0 && diasTransferencia <= 0) {
            taxa = valor * 0.025;
        } else if (diasTransferencia >= 1 && diasTransferencia <= 10) {
            taxa = 0.0;
        } else if (diasTransferencia >= 11 && diasTransferencia <= 20) {
            taxa = valor * 0.082;
        } else if (diasTransferencia >= 21 && diasTransferencia <= 30) {
            taxa = valor * 0.069;
        } else if (diasTransferencia >= 31 && diasTransferencia <= 40) {
            taxa = valor * 0.047;
        } else if (diasTransferencia >= 41 && diasTransferencia <= 50) {
            taxa = valor * 0.017;
        } else {
            System.out.println("Intervalo de dias de transferência inválido.");
        }

        return taxa;
    }

    public double subtrairValorDoSaldo(double saldo, LocalDateTime dataAtual, LocalDateTime dataTransferencia, double valor) {
        if (dataTransferencia == null) {
            System.out.println("Data de transferência não especificada.");
            return saldo;
        }

        if (dataAtual.toLocalDate().isEqual(dataTransferencia.toLocalDate())) {
            // Se a data de transferência for hoje, subtrai o valor do saldo
            saldo -= valor;
        } else {
            // Se a data de transferência for para outro dia, adicione o valor ao saldo
            // Isso presumindo que você queira adicionar o valor ao saldo e não a um campo separado
            saldo += valor;
        }

        return saldo;
    }


}

