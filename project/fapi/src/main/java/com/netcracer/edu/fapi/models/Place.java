package com.netcracer.edu.fapi.models;

public class Place {

    private Integer idPlace;
    private Integer seat;
    private Integer row;
    private Double price;
    private String isFree;
    private Session session;

    public Place() {
    }

    public Place(Integer idPlace, Integer seat, Integer row, Double price, String isFree, Session session) {
        this.idPlace = idPlace;
        this.seat = seat;
        this.row = row;
        this.price = price;
        this.isFree = isFree;
        this.session = session;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
