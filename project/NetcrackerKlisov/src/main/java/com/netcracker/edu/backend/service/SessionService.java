package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Film;
import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.entity.Session;

import java.text.ParseException;
import java.util.List;

public interface SessionService {
    Session findByDate(Integer date);
    Session findByTime(Double time);
//    void addPlaceToSession(Place place, Session session);
    public List<Session> findAll();
    Session save(Session session) throws ParseException;
    Hall findHall(Integer idSession);
    List<Place> findSessionPlace(Integer idSession);
    void delete(Integer idSession);
    Session findByIdSession(Integer idSession);
    Film findFilmByIdSession(Integer idSession);
}
