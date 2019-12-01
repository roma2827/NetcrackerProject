package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Cinema;
import com.netcracer.edu.fapi.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public Cinema saveCinema(@RequestBody Cinema cinema){
        return cinemaService.save(cinema);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{idCinema}", method = RequestMethod.DELETE)
    public void deleteCinema(@PathVariable(name = "idCinema") Integer idCinema){
        cinemaService.delete(idCinema);
    }

    @RequestMapping(value = "id/{idCinema}", method = RequestMethod.GET)
    public ResponseEntity<Cinema> getCinemaById(@PathVariable(name = "idCinema") Integer idCinema){
        Cinema cinema = cinemaService.findByIdCinema(idCinema);
        return ResponseEntity.ok(cinema);
    }
}
