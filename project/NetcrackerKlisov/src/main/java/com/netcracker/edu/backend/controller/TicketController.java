package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.service.PlaceService;
import com.netcracker.edu.backend.service.TicketService;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private PlaceService placeService;

    private Double price;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Ticket> getAllTicket(){
        return ticketService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ticket saveTicket(@RequestBody Ticket ticket){

       return ticketService.save(ticket);
    }

    @RequestMapping(value = "/{idTicket}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable(name = "idTicket") Integer idTicket){
        ticketService.delete(idTicket);
    }
}
