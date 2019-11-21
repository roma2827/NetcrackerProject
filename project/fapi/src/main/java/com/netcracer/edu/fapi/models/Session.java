package com.netcracer.edu.fapi.models;

public class Session {

    private Integer idSession;
    private Integer date;
    private Double time;
    private Film film;

    public Session() {
    }

    public Session(Integer idSession, Integer date, Double time, Film film) {
        this.idSession = idSession;
        this.date = date;
        this.time = time;
        this.film = film;
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
