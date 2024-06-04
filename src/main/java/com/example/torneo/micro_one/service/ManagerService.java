package com.example.torneo.micro_one.service;

import com.example.torneo.micro_one.model.Game;
import com.example.torneo.micro_one.model.Manager;
import com.example.torneo.micro_one.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository repository;

    public Mono<Manager> saveManager(Manager manager){
        return Mono.just(repository.save(manager));
    }

    public Mono<Manager> getManagerById(Integer id){
        return Mono.just(repository.findById(id).get());
    }


    public Flux<Manager> getAllManagers(){
        return Flux.fromIterable(repository.findAll());
    }
}
