package com.example.torneo.micro_one.service;

import com.example.torneo.micro_one.controller.dto.TournamentDto;
import com.example.torneo.micro_one.model.Category;
import com.example.torneo.micro_one.model.Game;
import com.example.torneo.micro_one.model.Manager;
import com.example.torneo.micro_one.model.Tournament;
import com.example.torneo.micro_one.repository.CategoryRepository;
import com.example.torneo.micro_one.repository.GameRepository;
import com.example.torneo.micro_one.repository.ManagerRepository;
import com.example.torneo.micro_one.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepositoryepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private CategoryRepository categoryRepositoryrepository;
    @Autowired
    private ManagerRepository managerRepositoryrepository;

    public Mono<Tournament> saveTournament(TournamentDto tournamentDto){
        Game game = gameRepository.findById(tournamentDto.getGameId()).get();
        Category category = categoryRepositoryrepository.findById(tournamentDto.getCategoryId()).get();
        Manager manager = managerRepositoryrepository.findById(tournamentDto.getManagerId()).get();
        Tournament tournament = new Tournament();
        tournament.setCategory(category);
        tournament.setGame(game);
        tournament.setManager(manager);
        tournament.setDate(tournamentDto.getDate());
        tournament.setCostView(tournamentDto.getCostView());
        tournament.setCostCompetitor(tournamentDto.getCostCompetitor());
        tournament.setName(tournamentDto.getName());

        return Mono.just(tournamentRepositoryepository.save(tournament));
    }

    public Mono<Tournament> getTournamentById(Integer id){
        return Mono.just(tournamentRepositoryepository.findById(id).get());
    }


    public Flux<Tournament> getAllTournaments(){
        return Flux.fromIterable(tournamentRepositoryepository.findAll());
    }
}
