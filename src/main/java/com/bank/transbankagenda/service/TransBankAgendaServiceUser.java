package com.bank.transbankagenda.service;

import com.bank.transbankagenda.model.TransBankAgenda;
import com.bank.transbankagenda.repository.TransBankAgendaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransBankAgendaServiceUser {

    private final TransBankAgendaRepository transBankAgendaRepository;

    @Autowired
    public TransBankAgendaServiceUser(TransBankAgendaRepository transBankAgendaRepository) {
        this.transBankAgendaRepository = transBankAgendaRepository;
    }

    @Transactional
    public void saveUsuario(TransBankAgenda transBankAgenda) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            transBankAgendaRepository.save(transBankAgenda);

        } catch (Exception e) {
            throw new RuntimeException("error ao adicionar usuario");
        }
    }

    public List<TransBankAgenda> getAllTransBankAgenda() {
        return transBankAgendaRepository.findAll();
    }

    public Optional<TransBankAgenda> getTransBankAgendaByid(Long id) {
        return transBankAgendaRepository.findById(id);

    }

    public void saveTransBankAgenda(TransBankAgenda saveTransBankAgenda) {
        transBankAgendaRepository.save(saveTransBankAgenda);
    }

    public void updateTransBankAgenda(Long id, TransBankAgenda updateTransBankAgenda) {
//        try {
//            TransBankAgenda existingTransBankAgenda = transBankAgendaRepository.getById(id);
//
//            // Verificar se a descrição  e o status  fornecida e atualizar
//            if (updateTransBankAgenda.() != null)
//                if (updateTransBankAgenda.isStatus()) {
//                    existingTransBankAgenda.setDescricao(updateTransBankAgenda.getDescricao());
//                }
//
//            // Atualizar o status
//            TransBankAgendaRepository.save(existingTransBankAgenda);
//        } catch (EntityNotFoundException e) {
//            throw new TransBankNotFoundException(id);
//        }
    }

    public void deletTransBankAgenda(Long id) {
        transBankAgendaRepository.deleteById(id);

    }
}
