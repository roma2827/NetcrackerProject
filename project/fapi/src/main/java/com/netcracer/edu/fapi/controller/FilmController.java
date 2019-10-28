package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Film;
import com.netcracer.edu.fapi.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Film> getFilmService(){
        return filmService.findAll();
    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Film saveFilm(@RequestBody Film film){
//        return filmService.save(film);
//    }
//
//    @RequestMapping(value = "/delete/{filmId}", method = RequestMethod.DELETE)
//    public void deleteFilm(@PathVariable(name = "filmId") Integer filmId){
//        filmService.delete(filmId);
//    }
}
