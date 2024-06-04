package com.example.torneo.micro_one.service;

import com.example.torneo.micro_one.controller.dto.TicketCDto;
import com.example.torneo.micro_one.controller.dto.TournamentDto;
import com.example.torneo.micro_one.model.*;
import com.example.torneo.micro_one.repository.CompetitorRepository;
import com.example.torneo.micro_one.repository.TicketCRepository;
import com.example.torneo.micro_one.repository.TournamentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TicketCService {
    @Autowired
    private TicketCRepository ticketCRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private CompetitorRepository competitorRepository;

    @Value("${spring.cloud.aws.sqs.endpoint}")
    private String SQSEndpoint;
    @Autowired
    private SqsTemplate queueMessagingSender;

    @Autowired
    private ObjectMapper objectMapper;

    public Mono<TicketC> saveTicketC(TicketCDto ticketCDto){
        Competitor competitor = competitorRepository.findById(ticketCDto.getCompetitorId()).get();
        Tournament tournament = tournamentRepository.findById(ticketCDto.getTournamentId()).get();
        TicketC ticketC = new TicketC();
        ticketC.setActiveTicket(ticketCDto.isActive());
        ticketC.setUseTicket(ticketCDto.isUse());
        ticketC.setCompetitor(competitor);
        ticketC.setTournament(tournament);

        return Mono.just(ticketCRepository.save(ticketC));
    }

    public Mono<TicketC> getTicketCById(Integer id){
        return Mono.just(ticketCRepository.findById(id).get());
    }


    public Flux<TicketC> getAllTicketC(){
        return Flux.fromIterable(ticketCRepository.findAll());
    }

    public Mono<TicketC> blockAccess(Integer id) throws JsonProcessingException {
        TicketC ticketC = ticketCRepository.findById(id).get();
        ticketC.setUseTicket(false);

        String ticketCJson = objectMapper.writeValueAsString(ticketC);
        Message<String> message = MessageBuilder
                .withPayload(ticketCJson)
                .setHeader("reason", "Bloquear ticket")
                .build();
        queueMessagingSender.send(SQSEndpoint, message);

        return Mono.just(ticketC);
    }

    public Mono<TicketC> unLockAccess(Integer id) throws JsonProcessingException{
        TicketC ticketC = ticketCRepository.findById(id).get();
        ticketC.setUseTicket(true);

        String ticketCJson = objectMapper.writeValueAsString(ticketC);
        Message<String> message = MessageBuilder
                .withPayload(ticketCJson)
                .setHeader("reason", "Desbloquear ticket")
                .build();
        queueMessagingSender.send(SQSEndpoint, message);

        return Mono.just(ticketC);
    }
}
