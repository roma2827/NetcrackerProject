package com.netcracer.edu.fapi.models;

public class Ticket {

    private Integer idTicket;
    private User user;
    private Session session;
    private Place place;

    public Ticket() {
    }

    public Ticket(Integer idTicket, User user, Session session, Place place) {
        this.idTicket = idTicket;
        this.user = user;
        this.session = session;
        this.place = place;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
