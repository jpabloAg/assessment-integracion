package com.example.torneo.micro_one.repository;

import com.example.torneo.micro_one.model.TicketV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketVRepository extends JpaRepository<TicketV, Integer> {
}
