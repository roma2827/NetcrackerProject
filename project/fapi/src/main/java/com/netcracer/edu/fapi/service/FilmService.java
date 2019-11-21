package com.netcracer.edu.fapi.service;

import com.netcracer.edu.fapi.models.Film;
import com.netcracer.edu.fapi.models.Session;

import java.util.List;

public interface FilmService {
    public List<Film> findAll();
    Film findByName(String name);
    Film saveFilm(Film film);
    void deleteFilm(Integer filmId);
    Film findByFilmId(Integer filmId);
    List<Session> findSessionsByFilmId(Integer filmId);
}
