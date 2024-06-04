package com.example.torneo.micro_one.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private int limitViwers;
    private int limitParticipants;
    private String alias;
    private boolean isFree;
    private String description;
    private float comission;
}
