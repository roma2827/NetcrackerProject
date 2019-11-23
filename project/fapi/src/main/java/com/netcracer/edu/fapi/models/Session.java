package com.netcracer.edu.fapi.models;

import java.util.Set;

public class Session {

    private Integer idSession;
    private Integer date;
    private Double time;
    private Film film;
    private Hall hall;
    private Set<Place> sessionsPlace;
    private Set<Ticket> tickets;

    public Session() {
    }

    public Session(Integer idSession, Integer date, Double time, Film film, Hall hall, Set<Place> sessionsPlace, Set<Ticket> tickets) {
        this.idSession = idSession;
        this.date = date;
        this.time = time;
        this.film = film;
        this.hall = hall;
        this.sessionsPlace = sessionsPlace;
        this.tickets = tickets;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Set<Place> getSessionsPlace() {
        return sessionsPlace;
    }

    public void setSessionsPlace(Set<Place> sessionsPlace) {
        this.sessionsPlace = sessionsPlace;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Integer getIdSession() {
        return idSession;
    }

    public void setIdSession(Integer idSession) {
        this.idSession = idSession;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
