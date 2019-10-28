package com.netcracker.edu.backend.entity;

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
    private Integer date;

    @Column
    @NotNull
    private Double time;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_film", nullable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_hall", nullable = false)
    private Hall hall;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "session")
//    private Set<Ticket> sessions;

    public Session() {
    }

    public Session(@NotNull Integer date, @NotNull Double time, Film film, Hall hall) {
        this.date = date;
        this.time = time;
        this.film = film;
        this.hall = hall;
    }
//    public Set<Ticket> getSessions() {
//        return sessions;
//    }
//
//    public void setSessions(Set<Ticket> sessions) {
//        this.sessions = sessions;
//    }

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
