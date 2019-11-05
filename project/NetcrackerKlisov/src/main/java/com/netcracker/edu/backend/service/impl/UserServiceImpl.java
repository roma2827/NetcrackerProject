package com.netcracker.edu.backend.service.impl;

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
    public User save(User user){
//        Wallet wallet = new Wallet();
//        wallet.setMoney(0d);
//        User createdUser = userRepository.save(user);
//        walletRepository.save(wallet);
//        return createdUser;
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer idUser){
        userRepository.deleteById(idUser);
    }
}
