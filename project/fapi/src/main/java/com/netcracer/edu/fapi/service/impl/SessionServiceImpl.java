package com.netcracer.edu.fapi.service.impl;

import com.netcracer.edu.fapi.models.Film;
import com.netcracer.edu.fapi.models.Hall;
import com.netcracer.edu.fapi.models.Place;
import com.netcracer.edu.fapi.models.Session;
import com.netcracer.edu.fapi.service.SessionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service()
public class SessionServiceImpl implements SessionService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Session findByDate(Integer date) {
        RestTemplate restTemplate = new RestTemplate();
        Session session = restTemplate.getForObject(backendServerUrl + "/api/session/date/" + date, Session.class);
        return session;
    }

    @Override
    public Session findByTime(Double time) {
        RestTemplate restTemplate = new RestTemplate();
        Session session = restTemplate.getForObject(backendServerUrl + "/api/session/time/" + time, Session.class);
        return session;
    }

    @Override
    public List<Session> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Session[] sessionsResponse = restTemplate.getForObject(backendServerUrl + "/api/session", Session[].class);
        return sessionsResponse == null ? Collections.emptyList() : Arrays.asList(sessionsResponse);
    }

    @Override
    public Session save(Session session) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/session", session, Session.class).getBody();
    }

    @Override
    public void delete(Integer idSession) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/session/" + idSession);
    }

    @Override
    public Session findByIdSession(Integer idSession) {
        RestTemplate restTemplate = new RestTemplate();
        Session session = restTemplate.getForObject(backendServerUrl + "/api/session/id/" + idSession, Session.class);
        return session;
    }

    @Override
    public Film findFilmByIdSession(Integer idSession) {
        RestTemplate restTemplate = new RestTemplate();
        Film film = restTemplate.getForObject(backendServerUrl + "/api/session/film/" + idSession, Film.class);
        return film;
    }

    @Override
    public Hall findHall(Integer idSession) {
        RestTemplate restTemplate = new RestTemplate();
        Hall hall = restTemplate.getForObject(backendServerUrl + "/api/session/hall/" + idSession, Hall.class);
        return hall;
    }

    @Override
    public List<Place> findSessionPlace(Integer idSession) {
        RestTemplate restTemplate = new RestTemplate();
        Place[] placesResponse = restTemplate.getForObject(backendServerUrl + "/api/session/place/" + idSession, Place[].class);
        return placesResponse == null ? Collections.emptyList() : Arrays.asList(placesResponse);
    }
}
