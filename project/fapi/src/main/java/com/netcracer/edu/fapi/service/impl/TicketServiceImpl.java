package com.netcracer.edu.fapi.service.impl;

import com.netcracer.edu.fapi.models.Ticket;
import com.netcracer.edu.fapi.service.TicketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service()
public class TicketServiceImpl implements TicketService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Ticket> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketsResponse = restTemplate.getForObject(backendServerUrl + "/api/ticket", Ticket[].class);
        return ticketsResponse == null ? Collections.emptyList() : Arrays.asList(ticketsResponse);
    }

    @Override
    public Ticket save(Ticket ticket) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/ticket", ticket, Ticket.class).getBody();
    }

    @Override
    public void delete(Integer idTicket) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/ticket/" + idTicket);
    }
}
