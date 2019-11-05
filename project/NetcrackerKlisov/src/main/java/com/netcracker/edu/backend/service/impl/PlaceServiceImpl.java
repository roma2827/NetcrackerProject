package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.repository.PlaceRepository;
import com.netcracker.edu.backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> findAll(){
        return (List<Place>) placeRepository.findAll();
    }

    @Override
    public Place save(Place place){
        return placeRepository.save(place);
    }

    @Override
    public void delete(Integer idPlace){
        placeRepository.deleteById(idPlace);
    }

    @Override
    public void updatePlaceIsFree(Integer idPlace){
        placeRepository.updatePlaceIsFree(idPlace);
    }

    @Override
    public Place findByIdPlace(Integer idPlace) {
        return placeRepository.findByIdPlace(idPlace);
    }
}
