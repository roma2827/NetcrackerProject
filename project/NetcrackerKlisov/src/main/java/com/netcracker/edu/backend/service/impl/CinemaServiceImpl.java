package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Cinema;
import com.netcracker.edu.backend.repository.CinemaRepository;
import com.netcracker.edu.backend.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> findAll() {
        return (List<Cinema>) cinemaRepository.findAll();
    }

    @Override
    public Cinema findByName(String name){
        return cinemaRepository.findByName(name);
    }

    @Override
    public Cinema save(Cinema cinema){
        return cinemaRepository.save(cinema);
    }

    @Override
    public void delete(Integer idCinema){
        cinemaRepository.deleteById(idCinema);
    }

    @Override
    public Cinema findByIdCinema(Integer idCinema){
        return cinemaRepository.findByIdCinema(idCinema);
    }
}
