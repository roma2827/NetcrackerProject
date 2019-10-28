package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Cinema;

import java.util.List;

public interface CinemaService {
    public List<Cinema> findAll();
    Cinema findByName(String name);
    Cinema findByIdCinema(Integer idCinema);
    Cinema save(Cinema cinema);
    void delete(Integer idCinema);
}
