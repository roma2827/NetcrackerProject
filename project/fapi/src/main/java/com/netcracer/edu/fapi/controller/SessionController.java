package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Film;
import com.netcracer.edu.fapi.models.Session;
import com.netcracer.edu.fapi.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    //    @Autowired
//    private PlaceService placeService;

    @RequestMapping(value = "/time/{time}", method = RequestMethod.GET)
    public ResponseEntity<Session> getSessionByTime(@PathVariable(name = "time") Double time){
        Session session = sessionService.findByTime(time);
        return ResponseEntity.ok(session);
    }

    @RequestMapping(value = "/date/{date}", method = RequestMethod.GET)
    public ResponseEntity<Session> getSessionByDate(@PathVariable(name = "date") Integer date){
        Session session = sessionService.findByDate(date);
        return ResponseEntity.ok(session);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Session>> getAllSessions(){
        List<Session> session = sessionService.findAll();
        return ResponseEntity.ok(session);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Session saveSession(@RequestBody Session session){
//        Session newSession = sessionService.save(session);
//        Place place = new Place();
//        place.setSession(newSession);
//        placeService.save(place);
        return sessionService.save(session);
//        return sessionService.save(newSession);
    }

    @RequestMapping(value = "/{idSession}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable(name = "idSession") Integer idSession){
        sessionService.delete(idSession);
    }

//    @RequestMapping(value = "/hall/{idSession}", method = RequestMethod.GET)
//    public ResponseEntity<Hall> getHall(@PathVariable(name = "idSession") Integer idSession){
//        Hall hall = sessionService.findHall(idSession);
//        return ResponseEntity.ok(hall);
//    }

//    @RequestMapping(value = "/place/{idSession}", method = RequestMethod.GET)
//    public ResponseEntity<List<Place>> getPlaces(@PathVariable(name = "idSession") Integer idSession){
//        List<Place> places = sessionService.findSessionPlace(idSession);
//        return ResponseEntity.ok(places);
//    }

    @RequestMapping(value = "/id/{idSession}", method = RequestMethod.GET)
    public ResponseEntity<Session> getSessionByIdSession(@PathVariable(name = "idSession") Integer idSession){
        Session session = sessionService.findByIdSession(idSession);
        return ResponseEntity.ok(session);
    }

    @RequestMapping(value = "/film/{idSession}", method = RequestMethod.GET)
    public ResponseEntity<Film> getFilmByIdSession(@PathVariable(name = "idSession") Integer idSession){
        Film film = sessionService.findFilmByIdSession(idSession);
        return ResponseEntity.ok(film);
    }
}
