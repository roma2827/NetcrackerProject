package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hall")
    private Integer idHall;

    @Column
    @NotNull
    @Size(max = 50)
    private String name;

    @Column(name = "n_seat")
    @NotNull
    private Integer nSeat;

    @Column(name = "n_row")
    @NotNull
    private Integer nRow;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_cinema")
    private Cinema cinema;

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "hall")
    private Set<Session> halls;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hall")
    private Set<Place> hallsPlace;*/

    public Hall() {
    }

    public Hall(@NotNull @Size(max = 50) String name, @NotNull Integer nSeat, @NotNull Integer nRow, Cinema cinema) {
        this.name = name;
        this.nSeat = nSeat;
        this.nRow = nRow;
        this.cinema = cinema;
    }

    /*public Set<Place> getHallsPlace() {
        return hallsPlace;
    }

    public void setHallsPlace(Set<Place> hallsPlace) {
        this.hallsPlace = hallsPlace;
    }

    public Set<Session> getHalls() {
        return halls;
    }

    public void setHalls(Set<Session> halls) {
        this.halls = halls;
    }*/

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Integer getIdHall() {
        return idHall;
    }

    public void setIdHall(Integer idHall) {
        this.idHall = idHall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getnSeat() {
        return nSeat;
    }

    public void setnSeat(Integer nSeat) {
        this.nSeat = nSeat;
    }

    public Integer getnRow() {
        return nRow;
    }

    public void setnRow(Integer nRow) {
        this.nRow = nRow;
    }
}
