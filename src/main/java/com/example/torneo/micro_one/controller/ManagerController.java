package com.example.torneo.micro_one.controller;

import com.example.torneo.micro_one.model.Game;
import com.example.torneo.micro_one.model.Manager;
import com.example.torneo.micro_one.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Autowired
    private ManagerService service;

    @PostMapping
    public Mono<Manager> saveManager(@RequestBody Manager manager){
        return service.saveManager(manager);
    }

    @GetMapping("/{id}")
    public Mono<Manager> getManagerById(@PathVariable("id") Integer id){
        return service.getManagerById(id);
    }

    @GetMapping
    public Flux<Manager> getAllManagers(){
        return service.getAllManagers();
    }
}
