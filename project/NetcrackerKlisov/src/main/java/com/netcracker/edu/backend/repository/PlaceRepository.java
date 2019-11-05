package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Place;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

    Place findByIdPlace(Integer idPlace);

    @Modifying
    @Transactional
    @Query("update Place p set p.isFree = 'false' where p.idPlace = :idPlace")
    void updatePlaceIsFree(@Param("idPlace") Integer idPlace);
}
