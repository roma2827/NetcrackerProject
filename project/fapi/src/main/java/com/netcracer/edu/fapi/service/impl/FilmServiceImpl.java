package com.netcracer.edu.fapi.service.impl;

import com.netcracer.edu.fapi.models.Film;
import com.netcracer.edu.fapi.models.Session;
import com.netcracer.edu.fapi.service.FilmService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service()
public class FilmServiceImpl implements FilmService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Film findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Film film = restTemplate.getForObject(backendServerUrl + "/api/films/name/" + name, Film.class);
        return film;
    }

    @Override
    public List<Film> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Film[] filmsResponse = restTemplate.getForObject(backendServerUrl + "/api/films", Film[].class);
        return filmsResponse == null ? Collections.emptyList() : Arrays.asList(filmsResponse);
    }

    @Override
    public Film saveFilm(Film film) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/films", film, Film.class).getBody();
    }

    @Override
    public void deleteFilm(Integer filmId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/films/" + filmId);
    }

    @Override
    public Film findByFilmId(Integer filmId) {
        RestTemplate restTemplate = new RestTemplate();
        Film film = restTemplate.getForObject(backendServerUrl + "/api/films/id/" + filmId, Film.class);
        return film;
    }

    @Override
    public List<Session> findSessionsByFilmId(Integer filmId){
        RestTemplate restTemplate = new RestTemplate();
        Session[] sessionResponse = restTemplate.getForObject(backendServerUrl + "api/films/session/" + filmId, Session[].class);
        return sessionResponse == null ? Collections.emptyList() : Arrays.asList(sessionResponse);
    }
}
