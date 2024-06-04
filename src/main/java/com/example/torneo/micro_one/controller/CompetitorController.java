package com.example.torneo.micro_one.controller;


import com.example.torneo.micro_one.model.Competitor;
import com.example.torneo.micro_one.model.Manager;
import com.example.torneo.micro_one.service.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/competitor")
public class CompetitorController {
    @Autowired
    private CompetitorService service;
    @PostMapping
    public Mono<Competitor> saveCompetitor(@RequestBody Competitor competitor){
        return service.saveCompetitor(competitor);
    }

    @GetMapping("/{id}")
    public Mono<Competitor> getCompetitorById(@PathVariable("id") Integer id){
        return service.getCompetitorById(id);
    }

    @GetMapping
    public Flux<Competitor> getAllCompetitors(){
        return service.getAllCompetitors();
    }
}
