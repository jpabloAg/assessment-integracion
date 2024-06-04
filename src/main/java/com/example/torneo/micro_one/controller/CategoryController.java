package com.example.torneo.micro_one.controller;

import com.example.torneo.micro_one.model.Category;
import com.example.torneo.micro_one.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService service;
    
    @PostMapping
    public Mono<Category> saveCategory(@RequestBody Category category){
        return service.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Mono<Category> getCategoryById(@PathVariable("id") Integer id){
        return service.getCategoryById(id);
    }

    @GetMapping
    public Flux<Category> getAllCategorys(){
        return service.getAllCategories();
    }
}
