package com.example.torneo.micro_one.controller;

import com.example.torneo.micro_one.controller.dto.TicketCDto;
import com.example.torneo.micro_one.model.Manager;
import com.example.torneo.micro_one.model.TicketC;
import com.example.torneo.micro_one.service.TicketCService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/ticketC")
public class TicketCController {
    @Autowired
    private TicketCService service;

    @PostMapping
    public Mono<TicketC> saveTicketC(@RequestBody TicketCDto ticketC){
        return service.saveTicketC(ticketC);
    }

    @GetMapping("/{id}")
    public Mono<TicketC> getTicketCById(@PathVariable("id") Integer id){
        return service.getTicketCById(id);
    }

    @GetMapping
    public Flux<TicketC> getAllTicketC(){
        return service.getAllTicketC();
    }

    @GetMapping("/block/{id}")
    public Mono<TicketC> blockTicketC(@PathVariable("id") Integer id) throws JsonProcessingException {
        return service.blockAccess(id);
    }

    @GetMapping("/unlock/{id}")
    public Mono<TicketC> unlockTicketC(@PathVariable("id") Integer id) throws JsonProcessingException {
        return service.unLockAccess(id);
    }
}
