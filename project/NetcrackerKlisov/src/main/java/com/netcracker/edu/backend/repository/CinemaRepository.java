package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Cinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Integer> {
    Cinema findByName(String name);
    Cinema findByIdCinema(Integer idCinema);
}
