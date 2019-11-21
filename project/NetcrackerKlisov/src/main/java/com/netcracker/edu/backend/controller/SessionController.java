package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Film;
import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.entity.Session;
import com.netcracker.edu.backend.service.FilmService;
import com.netcracker.edu.backend.service.HallService;
import com.netcracker.edu.backend.service.PlaceService;
import com.netcracker.edu.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private HallService hallService;

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
        Film film  = filmService.findByFilmId(session.getFilm().getFilmId());
        Hall hall = hallService.findByName(session.getHall().getName());
        session.setFilm(film);
        session.setHall(hall);
        for(int i = 1; i < 51; i++) {
            Place place = new Place();
            place.setSession(session);
            place.setIsFree("true");
            place.setPrice(7d);
            place.setSeat(i);
            if (i < 11){
                place.setRow(1);
            } else if (i < 21){
                place.setRow(2);
            } else if (i < 31){
                place.setRow(3);
            } else if (i < 41){
                place.setRow(4);
            } else
                place.setRow(5);

            placeService.save(place);
        }
        return sessionService.save(session);

//        Session newSession = sessionService.save(session);
//        Place place = new Place();
//        place.setSession(newSession);
//        placeService.save(place);
//        return sessionService.save(newSession);
    }

    @RequestMapping(value = "/{idSession}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable(name = "idSession") Integer idSession){
        sessionService.delete(idSession);
    }

    @RequestMapping(value = "/hall/{idSession}", method = RequestMethod.GET)
    public ResponseEntity<Hall> getHall(@PathVariable(name = "idSession") Integer idSession){
        Hall hall = sessionService.findHall(idSession);
        return ResponseEntity.ok(hall);
    }

    @RequestMapping(value = "/place/{idSession}", method = RequestMethod.GET)
    public ResponseEntity<List<Place>> getPlaces(@PathVariable(name = "idSession") Integer idSession){
        List<Place> places = sessionService.findSessionPlace(idSession);
        return ResponseEntity.ok(places);
    }

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
