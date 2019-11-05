package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.entity.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends CrudRepository<Hall, Integer> {
    Hall findByName(String name);

//    @Query("select h.hallsPlace from Hall h where h.idHall = :idHall")
//    List<Place> findPlaceByIdHall(@Param("idHall") Integer idHall);
}
