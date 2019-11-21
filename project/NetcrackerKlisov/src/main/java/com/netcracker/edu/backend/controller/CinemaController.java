package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Cinema;
import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping(value = "name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Cinema> getCinemaByName(@PathVariable(name = "name") String name){
        Cinema cinema = cinemaService.findByName(name);
        return ResponseEntity.ok(cinema);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Cinema> getCinemaService(){
        return cinemaService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cinema saveCinema(@RequestBody Cinema cinema){
        return cinemaService.save(cinema);
    }

    @RequestMapping(value = "/delete/{idCinema}", method = RequestMethod.DELETE)
    public void deleteCinema(@PathVariable(name = "idCinema") Integer idCinema){
        cinemaService.delete(idCinema);
    }

    @RequestMapping(value = "id/{idCinema}", method = RequestMethod.GET)
    public ResponseEntity<Cinema> getCinemaById(@PathVariable(name = "idCinema") Integer idCinema){
        Cinema cinema = cinemaService.findByIdCinema(idCinema);
        return ResponseEntity.ok(cinema);
    }

    @RequestMapping(value = "/halls/{idCinema}", method = RequestMethod.GET)
    public ResponseEntity<List<Hall>> getHallsByIdCinema(@PathVariable(name = "idCinema") Integer idCinema){
        List<Hall> halls = cinemaService.findHallsByIdCinema(idCinema);
        return ResponseEntity.ok(halls);
    }
}
