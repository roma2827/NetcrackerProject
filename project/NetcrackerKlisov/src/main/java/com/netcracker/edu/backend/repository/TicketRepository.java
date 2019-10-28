package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
