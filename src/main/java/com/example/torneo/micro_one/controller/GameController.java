package com.example.torneo.micro_one.controller;

import com.example.torneo.micro_one.model.Game;
import com.example.torneo.micro_one.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService service;

    @PostMapping
    public Mono<Game> saveGame(@RequestBody Game game){
        return service.saveGame(game);
    }

    @GetMapping("/{id}")
    public Mono<Game> getGameById(@PathVariable("id") Integer id){
        return service.getGameById(id);
    }

    @GetMapping
    public Flux<Game> getAllGames(){
        return service.getAllGames();
    }
}
