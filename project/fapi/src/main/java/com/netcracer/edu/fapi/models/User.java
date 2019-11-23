package com.netcracer.edu.fapi.models;

import java.util.Set;

public class User {

    private Integer idUser;
    private String role;
    private String login;
    private String password;
    private Wallet wallet;
    private Set<Ticket> tickets;

    public User() {
    }

    public User(Integer idUser, String role, String login, String password, Wallet wallet, Set<Ticket> tickets) {
        this.idUser = idUser;
        this.role = role;
        this.login = login;
        this.password = password;
        this.wallet = wallet;
        this.tickets = tickets;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
