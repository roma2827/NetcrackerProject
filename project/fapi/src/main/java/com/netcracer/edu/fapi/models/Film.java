package com.netcracer.edu.fapi.models;

import java.util.Set;

public class Film {

    private Integer filmId;
    private String name;
    private Double time;
    private String description;
    private Integer starData;
    private Integer endData;
    private String imj;
    private Set<Session> films;

    public Film() {
    }

    public Film(Integer filmId, String name, Double time, String description, Integer starData, Integer endData, String imj, Set<Session> films) {
        this.filmId = filmId;
        this.name = name;
        this.time = time;
        this.description = description;
        this.starData = starData;
        this.endData = endData;
        this.imj = imj;
        this.films = films;
    }

    public String getImj() {
        return imj;
    }

    public void setImj(String imj) {
        this.imj = imj;
    }

    public Set<Session> getFilms() {
        return films;
    }

    public void setFilms(Set<Session> films) {
        this.films = films;
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
