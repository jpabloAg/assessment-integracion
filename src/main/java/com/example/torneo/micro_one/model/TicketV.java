package com.example.torneo.micro_one.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ticketv")
public class TicketV {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private boolean activeTicket;
    private boolean useTicket;

    /*@JoinColumn(name = "id_tournament")
    @OneToOne
    private Tournament tournament;

    @JoinColumn(name = "id_viewer")
    @OneToOne
    private Viewer viewer;*/
}
