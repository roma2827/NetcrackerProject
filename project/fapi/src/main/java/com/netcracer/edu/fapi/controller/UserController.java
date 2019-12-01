package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Ticket;
import com.netcracer.edu.fapi.models.User;
import com.netcracer.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login){
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "idUser") Integer idUser){
        userService.delete(idUser);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/update-password/{idUser}", method = RequestMethod.POST)
    public void updatePassword(@PathVariable(name = "idUser") Integer idUser, @RequestBody String password){
        userService.updatePassword(idUser, password);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/ticket/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTicketByIdUser(@PathVariable(name = "idUser") Integer idUser){
        List<Ticket> ticket = userService.findTicketByIdUser(idUser);
        return ResponseEntity.ok(ticket);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/ticketByLogin/{login}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTicketByLogin(@PathVariable(name = "login") String login){
        List<Ticket> ticket = userService.findTicketByLogin(login);
        return ResponseEntity.ok(ticket);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/current")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByLogin(((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername());
    }
}
