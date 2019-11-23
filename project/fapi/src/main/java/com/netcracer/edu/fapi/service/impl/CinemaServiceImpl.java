package com.netcracer.edu.fapi.service.impl;

import com.netcracer.edu.fapi.models.Cinema;
import com.netcracer.edu.fapi.service.CinemaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Cinema> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Cinema[] cinemasResponse = restTemplate.getForObject(backendServerUrl + "/api/cinema", Cinema[].class);
        return cinemasResponse == null ? Collections.emptyList() : Arrays.asList(cinemasResponse);
    }

    @Override
    public Cinema findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Cinema cinema = restTemplate.getForObject(backendServerUrl + "/api/cinema/name/" + name, Cinema.class);
        return cinema;
    }

    @Override
    public Cinema findByIdCinema(Integer idCinema) {
        RestTemplate restTemplate = new RestTemplate();
        Cinema cinema = restTemplate.getForObject(backendServerUrl + "/api/cinema/id/" + idCinema, Cinema.class);
        return cinema;
    }

    @Override
    public Cinema save(Cinema cinema) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/cinema", cinema, Cinema.class).getBody();
    }

    @Override
    public void delete(Integer idCinema) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/cinema/delete/" + idCinema);
    }
}
