package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends CrudRepository<Hall, Integer> {
    Hall findByName(String name);
}
