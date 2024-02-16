package com.bank.transbankagenda.resource;

import com.bank.transbankagenda.model.TransBankAgenda;
import com.bank.transbankagenda.service.TransBankAgendaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bank", produces = {"application/json"})
@Tag(name = "TransbankAgenda")
public class TransBankAgendaController {

    private final TransBankAgendaService transBankAgendaService;

    @Autowired
    public TransBankAgendaController( TransBankAgendaService transBankAgendaService){
        this.transBankAgendaService = transBankAgendaService ;
    }

    @GetMapping
    public ResponseEntity<List<TransBankAgenda>> getallTrasnfer(){
//        List<TransBankAgenda> transBankAgenda = transBankAgendaServiceUser.getAllTrasnfer();
//        return  new ResponseEntity<>(transBankAgenda , HttpStatus.OK);
    return  null ;

    }
}
