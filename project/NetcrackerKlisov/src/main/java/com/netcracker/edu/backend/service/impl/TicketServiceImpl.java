package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.*;
import com.netcracker.edu.backend.repository.TicketRepository;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.PlaceService;
import com.netcracker.edu.backend.service.SessionService;
import com.netcracker.edu.backend.service.TicketService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<Ticket> findAll(){
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Override
    public Ticket save(Ticket ticket){
        Place place = placeService.findByIdPlace(ticket.getPlace().getIdPlace());
        Session session = sessionService.findByIdSession(ticket.getSession().getIdSession());
//        User user = userRepository.findById(ticket.getUser().getIdUser()).get();
//        Wallet wallet = walletRepository.findById(user.getWallet().getIdWallet()).get();
//        wallet.setMoney(wallet.getMoney() - ticket.getPlace().getPrice());
//        walletRepository.save(wallet);
        ticket.setSession(session);
        ticket.setPlace(place);
        return ticketRepository.save(ticket);
    }

    @Override
    public void delete(Integer idTicket){
        Ticket ticket = ticketRepository.findByIdTicket(idTicket);
        User user = userRepository.findById(ticket.getUser().getIdUser()).get();
        Wallet wallet = walletRepository.findById(user.getWallet().getIdWallet()).get();
        wallet.setMoney(wallet.getMoney() + ticket.getPlace().getPrice());
        Place place = ticket.getPlace();
        place.setIsFree("true");
        walletRepository.save(wallet);
        ticketRepository.deleteById(idTicket);
    }
}
