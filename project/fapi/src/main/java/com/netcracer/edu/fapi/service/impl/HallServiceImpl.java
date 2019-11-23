package com.netcracer.edu.fapi.service.impl;

import com.netcracer.edu.fapi.models.Hall;
import com.netcracer.edu.fapi.service.HallService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service()
public class HallServiceImpl implements HallService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Hall> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Hall[] hallsResponse = restTemplate.getForObject(backendServerUrl + "/api/hall", Hall[].class);
        return hallsResponse == null ? Collections.emptyList() : Arrays.asList(hallsResponse);
    }

    @Override
    public Hall findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Hall hall = restTemplate.getForObject(backendServerUrl + "/api/hall/name/" + name, Hall.class);
        return hall;
    }

    @Override
    public Hall save(Hall hall) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/hall", hall, Hall.class).getBody();
    }

    @Override
    public void delete(Integer idHall) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/hall/delete/" + idHall);
    }
}
