package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cinema")
    private Integer idCinema;

    @Column
    @NotNull
    @Size(max = 50)
    private String name;

    @Column
    @NotNull
    @Size(max = 100)
    private String address;

    public Cinema() {
    }

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "cinema")
    private Set<Hall> cinemas;

    public Set<Hall> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Hall> cinemas) {
        this.cinemas = cinemas;
    }*/

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
