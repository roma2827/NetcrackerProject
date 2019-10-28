package com.netcracer.edu.fapi.service;

import com.netcracer.edu.fapi.models.Film;

import java.util.List;

public interface FilmService {
    public List<Film> findAll();
    Film findByName(String name);
//    Film save(Film film);
//    void delete(Integer filmId);
}
