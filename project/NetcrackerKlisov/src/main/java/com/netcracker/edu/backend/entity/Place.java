package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_place")
    private Integer idPlace;

    @Column
    @NotNull
    private Integer seat;

    @Column
    @NotNull
    private Integer row;

    @Column(name = "is_free")
    @Size(max = 10)
    @NotNull
    private String isFree;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_hall")
    private Hall hall;

//    @OneToOne(optional = false, mappedBy="place")
//    public Ticket ticket;

    public Place() {
    }

    public Place(@NotNull Integer seat, @NotNull Integer row, @Size(max = 10) @NotNull String isFree, Hall hall) {
        this.seat = seat;
        this.row = row;
        this.isFree = isFree;
        this.hall = hall;
    }

    /*public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }*/

    public Integer getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }
}
