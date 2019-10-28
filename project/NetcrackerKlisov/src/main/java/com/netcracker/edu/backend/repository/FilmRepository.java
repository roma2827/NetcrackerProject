package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
    Film findByName(String name);
    Film findByFilmId(Integer filmId);
}
