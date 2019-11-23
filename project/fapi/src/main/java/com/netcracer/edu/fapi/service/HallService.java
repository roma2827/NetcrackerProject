package com.netcracer.edu.fapi.service;

import com.netcracer.edu.fapi.models.Hall;

import java.util.List;

public interface HallService {
    public List<Hall> findAll();
    Hall findByName(String name);
    Hall save(Hall hall);
    void delete(Integer idHall);
}
