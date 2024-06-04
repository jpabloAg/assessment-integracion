package com.example.torneo.micro_one.repository;

import com.example.torneo.micro_one.model.TicketC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCRepository extends JpaRepository<TicketC, Integer> {
}
