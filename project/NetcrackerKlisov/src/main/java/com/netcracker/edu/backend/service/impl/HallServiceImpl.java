package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Cinema;
import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.repository.CinemaRepository;
import com.netcracker.edu.backend.repository.HallRepository;
import com.netcracker.edu.backend.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Hall> findAll(){
        return (List<Hall>) hallRepository.findAll();
    }

    @Override
    public Hall findByName(String name){
        return hallRepository.findByName(name);
    }

    @Override
    public Hall save(Hall hall){
        Cinema cinema = cinemaRepository.findByIdCinema(hall.getCinema().getIdCinema());
        hall.setCinema(cinema);
        return hallRepository.save(hall);
    }

    @Override
    public void delete(Integer idHall){
        hallRepository.deleteById(idHall);
    }

//    @Override
//    public List<Place> findPlacesByIdHall(Integer idHall){
//        return hallRepository.findPlaceByIdHall(idHall);
//    }
}
