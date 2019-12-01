package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.LoginMessage;
import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByLogin(String login);
    User save(User user);
    User findByIdUser(Integer idUser);
    void delete(Integer idUser);
    void updatePassword(Integer idUser, String password);
    List<Ticket> findTicketByIdUser(Integer idUser);
    List<Ticket> findTicketByLogin(String login);
    LoginMessage login(User user);
}
