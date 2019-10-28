package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Hall;

import java.util.List;

public interface HallService {
    public List<Hall> findAll();
    Hall findByName(String name);
    Hall save(Hall hall);
    void delete(Integer idHall);
}
