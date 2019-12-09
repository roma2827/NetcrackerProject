package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session")
    private Integer idSession;

    @Column
    @NotNull
    private String date;

    @Column
    @NotNull
    private String time;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_film")
//    @JsonIgnore
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_hall")
//    @JsonBackReference
    private Hall hall;

    @OneToMany(orphanRemoval=true, fetch = FetchType.EAGER, mappedBy = "session")
//    @JsonManagedReference
    @JsonIgnore
    private Set<Place> sessionsPlace;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "session")
    @JsonIgnore
    private Set<Ticket> tickets;

    public Session() {
    }

    public Session(@NotNull String date, @NotNull String time, Film film, Hall hall, Set<Place> sessionsPlace, Set<Ticket> tickets) {
        this.date = date;
        this.time = time;
        this.film = film;
        this.hall = hall;
        this.sessionsPlace = sessionsPlace;
        this.tickets = tickets;
    }

    public Set<Place> getSessionsPlace() {
        return sessionsPlace;
    }

    public void setSessionsPlace(Set<Place> sessionsPlace) {
        this.sessionsPlace = sessionsPlace;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Integer getIdSession() {
        return idSession;
    }

    public void setIdSession(Integer idSession) {
        this.idSession = idSession;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
