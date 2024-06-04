package com.example.torneo.micro_one.controller.dto;

import com.example.torneo.micro_one.model.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TournamentDto {
    private Date date;
    private float costView;
    private float costCompetitor;
    private String name;
    private Integer managerId;
    private Integer categoryId;
    private Integer gameId;
}