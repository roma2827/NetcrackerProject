package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.repository.TicketRepository;
import com.netcracker.edu.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAll(){
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Override
    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    @Override
    public void delete(Integer idTicket){
        ticketRepository.deleteById(idTicket);
    }
}
