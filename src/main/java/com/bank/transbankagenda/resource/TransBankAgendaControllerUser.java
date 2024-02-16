package com.bank.transbankagenda.resource;


import com.bank.transbankagenda.model.TransBankAgenda;
import com.bank.transbankagenda.service.TransBankAgendaServiceUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/user", produces = {"application/json"})
@Tag(name = "TransbankAgendaUser")
public class TransBankAgendaControllerUser {

    private final TransBankAgendaServiceUser transBankAgendaServiceUser;


    public TransBankAgendaControllerUser(TransBankAgendaServiceUser transBankAgendaServiceUser) {
        this.transBankAgendaServiceUser = transBankAgendaServiceUser;
    }

    @GetMapping
    public ResponseEntity<List<TransBankAgenda>> GetAllUsers() {
        List<TransBankAgenda> transBankAgenda = transBankAgendaServiceUser.getAllTransBankAgenda();
        return new ResponseEntity<>(transBankAgenda, HttpStatus.OK);

    }

    @PostMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<TransBankAgenda> addUser(@RequestBody TransBankAgenda transBankAgenda) {
        transBankAgendaServiceUser.saveTransBankAgenda(transBankAgenda);
        return new ResponseEntity<>(transBankAgenda, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TransBankAgenda> updateUser(@PathVariable Long id, @RequestBody TransBankAgenda transBankAgenda) {
        transBankAgendaServiceUser.updateTransBankAgenda(id, transBankAgenda);
        return new ResponseEntity<>(transBankAgenda, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TransBankAgenda> DeleteUser(@PathVariable Long id) {
        transBankAgendaServiceUser.deletTransBankAgenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}



