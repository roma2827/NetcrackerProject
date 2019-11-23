package com.netcracer.edu.fapi.models;

public class Cinema {

    private Integer idCinema;
    private String name;
    private String address;

    public Cinema() {
    }

    public Cinema(Integer idCinema, String name, String address) {
        this.idCinema = idCinema;
        this.name = name;
        this.address = address;
    }

    public Integer getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Integer idCinema) {
        this.idCinema = idCinema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
