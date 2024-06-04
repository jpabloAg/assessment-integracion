package com.example.torneo.micro_one.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date date;
    private float costView;
    private float costCompetitor;
    private String name;

    @JoinColumn(name = "id_manager")
    @OneToOne
    private Manager manager;

    @JoinColumn(name = "id_category")
    @OneToOne
    private Category category;

    @JoinColumn(name = "id_game")
    @OneToOne
    private Game game;
}
