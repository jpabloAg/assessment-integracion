package com.example.torneo.micro_one.service;

import com.example.torneo.micro_one.model.Game;
import com.example.torneo.micro_one.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public Mono<Game> saveGame(Game game){
        return Mono.just(repository.save(game));
    }

    public Mono<Game> getGameById(Integer id){
        return Mono.just(repository.findById(id).get());
    }


    public Flux<Game> getAllGames(){
        return Flux.fromIterable(repository.findAll());
    }
}
