package com.bank.transbankagenda.service;

import com.bank.transbankagenda.model.TransBankAgenda;
import com.bank.transbankagenda.repository.TransBankAgendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudTransBankAgendaService {

    private TransBankAgendaRepository transBankAgendaRepository;

@Transactional
    public  void AddUser(TransBankAgenda transBankAgenda){
    transBankAgendaRepository.save(transBankAgenda);

}

    public List<TransBankAgenda> getAllTrasnfer() {
    return  transBankAgendaRepository.findAll();
    }

    public Optional<TransBankAgenda> getTrasnferByid(Long id) {
        return  transBankAgendaRepository.findById(id);
    }
    public void salveUser(TransBankAgenda transBankAgenda){
    transBankAgendaRepository.save(transBankAgenda);
    }


    public  void updateUser(Long id , TransBankAgenda updateUser) {

        try {
            TransBankAgenda existingTransBankAgenda = transBankAgendaRepository.getById(id);


        } catch (Exception e) {
        }

    }

    public void deleteUser(Long id) {
        transBankAgendaRepository.deleteById(id);

    }




}
