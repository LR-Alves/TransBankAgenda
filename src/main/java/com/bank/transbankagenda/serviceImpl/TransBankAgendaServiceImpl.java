package com.bank.transbankagenda.serviceImpl;

import com.bank.transbankagenda.model.TransBankAgenda;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Service
public class TransBankAgendaServiceImpl {


    private void subtrairValorDoSaldo(TransBankAgenda transBankAgenda, double valor, LocalDateTime dataAtual) {

//        double taxa = calcularTaxaTransferencia(dataAtual, transBankAgenda.getdataTransferencia(), valor);
//        double novoSaldo = transBankAgenda.getSaldo() - (valor + taxa);
//        transBankAgenda.setSaldo(novoSaldo);
//        transBankAgenda.setDataTransferencia(dataAtual); // Atualiza a data de transferência
    }


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

    public double subtrairValorDoSaldo(TransBankAgenda transBankAgenda, double saldo, LocalDateTime dataAtual, LocalDateTime dataTransferencia, double valor) {
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
