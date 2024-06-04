package com.example.torneo.micro_one.service;

import com.example.torneo.micro_one.model.Competitor;
import com.example.torneo.micro_one.model.Game;
import com.example.torneo.micro_one.repository.CompetitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompetitorService {
    @Autowired
    private CompetitorRepository repository;

    public Mono<Competitor> saveCompetitor(Competitor competitor){
        return Mono.just(repository.save(competitor));
    }

    public Mono<Competitor> getCompetitorById(Integer id){
        return Mono.just(repository.findById(id).get());
    }


    public Flux<Competitor> getAllCompetitors(){
        return Flux.fromIterable(repository.findAll());
    }
}
