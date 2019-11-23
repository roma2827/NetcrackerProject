package com.netcracer.edu.fapi.service.impl;

import com.netcracer.edu.fapi.models.Ticket;
import com.netcracer.edu.fapi.models.User;
import com.netcracer.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service()
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<User> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/user", User[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public User findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendServerUrl + "/api/user/login/" + login, User.class);
        return user;
    }

    @Override
    public User save(User user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, User.class).getBody();
    }

    @Override
    public void delete(Integer idUser) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/user/" + idUser);
    }

    //    ПЕРЕПИСАТЬ
    @Override
    public void updatePassword(Integer idUser, String password) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(backendServerUrl + "/api/user/" + idUser, password, User.class);
    }

    @Override
    public List<Ticket> findTicketByIdUser(Integer idUser) {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketsResponse = restTemplate.getForObject(backendServerUrl + "api/user/ticket/" + idUser, Ticket[].class);
        return ticketsResponse == null ? Collections.emptyList() : Arrays.asList(ticketsResponse);
    }

    @Override
    public List<Ticket> findTicketByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        Ticket[] ticketsResponse = restTemplate.getForObject(backendServerUrl + "api/user/ticketByLogin/" + login, Ticket[].class);
        return ticketsResponse == null ? Collections.emptyList() : Arrays.asList(ticketsResponse);
    }

//    ПЕРЕПИСАТЬ
    @Override
    public String login(User user) {
        RestTemplate restTemplate = new RestTemplate();
        return null;
    }
}
