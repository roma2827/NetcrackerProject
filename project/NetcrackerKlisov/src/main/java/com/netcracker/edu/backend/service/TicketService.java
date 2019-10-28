package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
    Ticket save(Ticket ticket);
    void delete(Integer idTicket);
}
