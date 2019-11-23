package com.netcracer.edu.fapi.service;

import com.netcracer.edu.fapi.models.Cinema;

import java.util.List;

public interface CinemaService {
    public List<Cinema> findAll();
    Cinema findByName(String name);
    Cinema findByIdCinema(Integer idCinema);
    Cinema save(Cinema cinema);
    void delete(Integer idCinema);
}
