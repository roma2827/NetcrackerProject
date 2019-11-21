package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    Ticket findByIdTicket(Integer idTicket);
}
