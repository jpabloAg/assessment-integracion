package com.example.torneo.micro_one.service;

import com.example.torneo.micro_one.model.Manager;
import com.example.torneo.micro_one.model.Viewer;
import com.example.torneo.micro_one.repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ViewerService {
    @Autowired
    private ViewerRepository repository;

    public Mono<Viewer> saveViewer(Viewer viewer){
        return Mono.just(repository.save(viewer));
    }

    public Mono<Viewer> getViewerById(Integer id){
        return Mono.just(repository.findById(id).get());
    }


    public Flux<Viewer> getAllViewers(){
        return Flux.fromIterable(repository.findAll());
    }
}
