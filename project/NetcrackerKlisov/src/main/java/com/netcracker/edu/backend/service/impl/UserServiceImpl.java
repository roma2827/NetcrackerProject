package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private static final String INCORRECT_LOGIN_EXCEPTION = "Incorrect login. Please try again";
    private static final String INCORRECT_PASSWORD_EXCEPTION = "Incorrect password. Please try again";
    private static final String OK = "OK";

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    @Override
    public User save(User user) {
        user.setRole("USER");
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer idUser){
        userRepository.deleteById(idUser);
    }

    @Override
    public void updatePassword(Integer idUser, String password){
        userRepository.updatePassword(idUser, password);
    }

    @Override
    public List<Ticket> findTicketByIdUser(Integer idUser){
        return userRepository.findTicketByIdUser(idUser);
    }

    @Override
    public List<Ticket> findTicketByLogin(String login) {
        return userRepository.findTicketByLogin(login);
    }

    @Override
    public String login(User user) {
        User databaseUser = userRepository.findByLogin(user.getLogin());
        if (databaseUser == null) {
            return INCORRECT_LOGIN_EXCEPTION;
        }
        if (!user.getPassword().equals(databaseUser.getPassword())) {
            return INCORRECT_PASSWORD_EXCEPTION;
        }
        return OK;
    }
}
