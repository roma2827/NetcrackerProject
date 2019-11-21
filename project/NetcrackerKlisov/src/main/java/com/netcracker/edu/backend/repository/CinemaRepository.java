package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Cinema;
import com.netcracker.edu.backend.entity.Hall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Integer> {
    Cinema findByName(String name);
    Cinema findByIdCinema(Integer idCinema);

//    @Query("select c.cinemas from Cinema c where c.idCinema = :idCinema")
    List<Hall> findHallsByIdCinema(@Param("idCinema") Integer idCinema);
}
