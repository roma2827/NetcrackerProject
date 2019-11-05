package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Place;

import java.util.List;

public interface PlaceService {
    List<Place> findAll();
    Place save(Place place);
    void delete(Integer idPlace);
    void updatePlaceIsFree(Integer idPlace);
    Place findByIdPlace(Integer idPlace);
}
