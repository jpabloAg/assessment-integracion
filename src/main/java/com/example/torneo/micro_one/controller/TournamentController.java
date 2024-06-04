package com.example.torneo.micro_one.controller;

import com.example.torneo.micro_one.controller.dto.TournamentDto;
import com.example.torneo.micro_one.model.Game;
import com.example.torneo.micro_one.model.Tournament;
import com.example.torneo.micro_one.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

    @Autowired
    private TournamentService service;

    @PostMapping
    public Mono<Tournament> saveTournament(@RequestBody TournamentDto tournament){
        return service.saveTournament(tournament);
    }

    @GetMapping("/{id}")
    public Mono<Tournament> getTournamentById(@PathVariable("id") Integer id){
        return service.getTournamentById(id);
    }

    @GetMapping
    public Flux<Tournament> getAllTournaments(){
        return service.getAllTournaments();
    }
}
