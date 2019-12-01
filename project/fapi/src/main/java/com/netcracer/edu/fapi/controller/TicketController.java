package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Ticket;
import com.netcracer.edu.fapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Ticket> getAllTicket(){
        return ticketService.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(method = RequestMethod.POST)
    public Ticket saveTicket(@RequestBody Ticket ticket){
        return ticketService.save(ticket);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/{idTicket}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable(name = "idTicket") Integer idTicket){
        ticketService.delete(idTicket);
    }
}
