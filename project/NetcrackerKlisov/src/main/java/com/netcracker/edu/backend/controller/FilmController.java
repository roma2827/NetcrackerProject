package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Film;
import com.netcracker.edu.backend.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.netcracker.edu.backend.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Film> getFilmByName(@PathVariable(name = "name") String name){
        Film film = filmService.findByName(name);
        return ResponseEntity.ok(film);
    }

    @RequestMapping(value = "/id/{filmId}", method = RequestMethod.GET)
    public ResponseEntity<Film> getFilmByFilmId(@PathVariable(name = "filmId") Integer filmId){
        Film film = filmService.findByFilmId(filmId);
        return ResponseEntity.ok(film);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Film> getFilmService(){
        return filmService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Film saveFilm(@RequestBody Film film){
        return filmService.save(film);
    }

    @RequestMapping(value = "/{filmId}", method = RequestMethod.DELETE)
    public void deleteFilm(@PathVariable(name = "filmId") Integer filmId){
        filmService.delete(filmId);
    }

    @RequestMapping(value = "/session/{filmId}", method = RequestMethod.GET)
    public ResponseEntity<List<Session>> getSessionByFilmId(@PathVariable(name = "filmId") Integer filmId){
        List<Session> sessions = filmService.findSessionsByFilmId(filmId);
        return ResponseEntity.ok(sessions);
    }
}