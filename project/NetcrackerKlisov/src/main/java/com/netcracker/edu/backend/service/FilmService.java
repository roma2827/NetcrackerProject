package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Film;

import java.util.List;

public interface FilmService {
    public List<Film> findAll();
    Film findByName(String name);
    Film save(Film film);
    void delete(Integer filmId);
    Film findByFilmId(Integer filmId);
}
