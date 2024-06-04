package com.example.torneo.micro_one.controller.dto;

import com.example.torneo.micro_one.model.Competitor;
import com.example.torneo.micro_one.model.Tournament;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketCDto {
    private boolean active;
    private boolean use;

    private Integer tournamentId;
    private Integer competitorId;
}
