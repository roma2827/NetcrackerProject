package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.netcracker.edu.backend.repository.FilmRepository;
import com.netcracker.edu.backend.service.FilmService;

import java.util.List;

@Component
public class FilmServerImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> findAll() {
        return (List<Film>) filmRepository.findAll();
    }

    @Override
    public Film findByName(String name){
        return filmRepository.findByName(name);
    }

    @Override
    public Film findByFilmId(Integer filmId){
        return  filmRepository.findByFilmId(filmId);
    }

    @Override
    public Film save(Film film){
        return filmRepository.save(film);
    }

    @Override
    public void delete(Integer filmId){
        filmRepository.deleteById(filmId);
    }
}