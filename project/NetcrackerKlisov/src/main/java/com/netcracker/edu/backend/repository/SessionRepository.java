package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.entity.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {
    Session findByDate(Integer date);
    Session findByTime(double time);
    Session findByIdSession(Integer idSession);

    @Query("select s.hall from Session s where s.idSession = :idSession")
    Hall findHall(@Param("idSession") Integer idSession);

    @Query("select s.sessionsPlace from Session s where s.idSession = :idSession")
    List<Place> findSessionPlace(@Param("idSession") Integer idSession);
}
