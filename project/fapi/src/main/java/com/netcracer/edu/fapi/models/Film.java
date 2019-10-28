package com.netcracer.edu.fapi.models;

public class Film {

    private Integer filmId;
    private String name;
    private Double time;
    private String description;
    private Integer starData;
    private Integer endData;

    public Film() {
    }

    public Film(Integer filmId, String name, Double time, String description, Integer starData, Integer endData) {
        this.filmId = filmId;
        this.name = name;
        this.time = time;
        this.description = description;
        this.starData = starData;
        this.endData = endData;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStarData() {
        return starData;
    }

    public void setStarData(Integer starData) {
        this.starData = starData;
    }

    public Integer getEndData() {
        return endData;
    }

    public void setEndData(Integer endData) {
        this.endData = endData;
    }
}
