package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Integer filmId;

    @Column(name = "name")
    @NotNull
    @Size(max = 50)
    private String name;

    @Column
    @NotNull
    @Size(max = 200)
    private String description;

    @Column
    @NotNull
    //@FutureOrPresent
    private Double time;

    @Column(name = "start_data")
    @NotNull
    //@FutureOrPresent
    private Integer startData;

    @Column(name = "end_data")
    @NotNull
    //@FutureOrPresent
    private  Integer endData;

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "film")
    private Set<Session> films;*/

    public Film() {
    }

    /*public Set<Session> getFilms() {
        return films;
    }

    public void setFilms(Set<Session> films) {
        this.films = films;
    }*/

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Integer getStartData() {
        return startData;
    }

    public void setStartData(Integer startData) {
        this.startData = startData;
    }

    public Integer getEndData() {
        return endData;
    }

    public void setEndData(Integer endData) {
        this.endData = endData;
    }
}