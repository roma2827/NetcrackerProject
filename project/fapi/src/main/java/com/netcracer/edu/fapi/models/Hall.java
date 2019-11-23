package com.netcracer.edu.fapi.models;

public class Hall {

    private Integer idHall;
    private String name;
    private Integer nSeat;
    private Integer nRow;
    private Cinema cinema;

    public Hall() {
    }

    public Hall(Integer idHall, String name, Integer nSeat, Integer nRow, Cinema cinema) {
        this.idHall = idHall;
        this.name = name;
        this.nSeat = nSeat;
        this.nRow = nRow;
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

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
