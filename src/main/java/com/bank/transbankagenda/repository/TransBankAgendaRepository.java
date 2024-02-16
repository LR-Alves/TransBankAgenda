package com.bank.transbankagenda.repository;

import com.bank.transbankagenda.model.TransBankAgenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransBankAgendaRepository extends JpaRepository<TransBankAgenda, Long> {

}
