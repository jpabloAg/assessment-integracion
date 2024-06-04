package com.example.torneo.micro_one.service;

import com.example.torneo.micro_one.model.Category;
import com.example.torneo.micro_one.model.Game;
import com.example.torneo.micro_one.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Mono<Category> saveCategory(Category category){
        return Mono.just(repository.save(category));
    }

    public Mono<Category> getCategoryById(Integer id){
        return Mono.just(repository.findById(id).get());
    }


    public Flux<Category> getAllCategories(){
        return Flux.fromIterable(repository.findAll());
    }
}
