package com.example.torneo.micro_one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExchangeRateController {
    @Autowired
    private ExchangeRateRepository repository;

    @GetMapping("/exchangerate")
    public List<ExchangeRate> getAll(){
        return repository.findAll();
    }

    @PostMapping("/exchangerate")
    public ExchangeRate addExchangeRate(@RequestBody ExchangeRate exchangeRate){
        return repository.save(exchangeRate);
    }

    @GetMapping("/")
    public String getHealth(){ return "up"; }
}