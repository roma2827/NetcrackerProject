package com.netcracer.edu.fapi.service.impl;

import com.netcracer.edu.fapi.models.Place;
import com.netcracer.edu.fapi.service.PlaceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service()
public class PlaceServiceImpl implements PlaceService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Place> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Place[] placesResponse = restTemplate.getForObject(backendServerUrl + "/api/place", Place[].class);
        return placesResponse == null ? Collections.emptyList() : Arrays.asList(placesResponse);
    }

    @Override
    public Place save(Place place) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/place", place, Place.class).getBody();
    }

    @Override
    public void delete(Integer idPlace) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/place/" + idPlace);
    }

    @Override
    public void updatePlaceIsFree(Integer idPlace) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(backendServerUrl + "/api/place/update-place", idPlace, Void.class);
    }

    @Override
    public Place findByIdPlace(Integer idPlace) {
        RestTemplate restTemplate = new RestTemplate();
        Place place = restTemplate.getForObject(backendServerUrl + "/api/place/" + idPlace, Place.class);
        return place;
    }

}
