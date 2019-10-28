package com.netcracer.edu.fapi.service.impl;

import com.netcracer.edu.fapi.models.Film;
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
        Film[] filmsResponse = restTemplate.getForObject(backendServerUrl + "/api/films/all", Film[].class);
        return filmsResponse == null ? Collections.emptyList() : Arrays.asList(filmsResponse);
    }
}
