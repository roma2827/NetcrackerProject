package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {
    Session findByDate(Integer date);
    Session findByTime(double time);
}
