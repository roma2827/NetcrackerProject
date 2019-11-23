package com.netcracer.edu.fapi.service;

import com.netcracer.edu.fapi.models.Place;

import java.util.List;

public interface PlaceService {
    List<Place> findAll();
    Place save(Place place);
    void delete(Integer idPlace);
    void updatePlaceIsFree(Integer idPlace);
    Place findByIdPlace(Integer idPlace);
}
