package com.bank.transbankagenda;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(info = @Info(title = "Transbankagenda", version = "0.1", description = "API Transbankagenda"))

@SpringBootApplication
public class TransBankAgendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransBankAgendaApplication.class, args);
    }

}
