package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.UserService;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
        public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login){
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        User newUser = userService.save(user);
        Wallet wallet = new Wallet();
        wallet.setMoney(0d);
        newUser.setWallet(wallet);
        walletService.save(wallet);
        return userService.save(user);
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "idUser") Integer idUser){
        userService.delete(idUser);
    }

    @RequestMapping(value = "/update-password/{idUser}", method = RequestMethod.POST)
    public void updatePassword(@PathVariable(name = "idUser") Integer idUser, @RequestBody String password){
        userService.updatePassword(idUser, password);
    }

    @RequestMapping(value = "/ticket/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTicketByIdUser(@PathVariable(name = "idUser") Integer idUser){
        List<Ticket> ticket = userService.findTicketByIdUser(idUser);
        return ResponseEntity.ok(ticket);
    }

    @RequestMapping(value = "/ticketByLogin/{login}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTicketByLogin(@PathVariable(name = "login") String login){
        List<Ticket> ticket = userService.findTicketByLogin(login);
        return ResponseEntity.ok(ticket);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        return userService.login(user);
    }
}
