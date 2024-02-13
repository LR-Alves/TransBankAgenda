package com.bank.transbankagenda.resource;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bank", produces = {"application/json"})
@Tag(name = "TransbankAgenda")
public class TransBankAgendaController {
}
