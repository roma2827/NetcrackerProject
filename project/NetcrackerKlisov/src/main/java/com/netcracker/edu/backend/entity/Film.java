package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @Size(max = 2000)
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

    @Column
    private String imj;

    @OneToMany(orphanRemoval=true, fetch = FetchType.EAGER, mappedBy = "film")
    @JsonIgnore
    private Set<Session> films;

    public Film() {
    }

    public Film(@NotNull @Size(max = 50) String name, @NotNull @Size(max = 2000) String description, @NotNull Double time, @NotNull Integer startData, @NotNull Integer endData, String imj, Set<Session> films) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.startData = startData;
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