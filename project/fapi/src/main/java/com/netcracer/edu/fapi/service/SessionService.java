package com.netcracer.edu.fapi.service;

import com.netcracer.edu.fapi.models.Film;
import com.netcracer.edu.fapi.models.Hall;
import com.netcracer.edu.fapi.models.Place;
import com.netcracer.edu.fapi.models.Session;

import java.util.List;

public interface SessionService {
    Session findByDate(Integer date);
    Session findByTime(Double time);
    public List<Session> findAll();
    Session save(Session session);
    Hall findHall(Integer idSession);
    List<Place> findSessionPlace(Integer idSession);
    void delete(Integer idSession);
    Session findByIdSession(Integer idSession);
    Film findFilmByIdSession(Integer idSession);
}
