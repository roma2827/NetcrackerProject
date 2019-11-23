package com.netcracer.edu.fapi.service;

import com.netcracer.edu.fapi.models.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
    Ticket save(Ticket ticket);
    void delete(Integer idTicket);
}
