package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Film;
import com.netcracker.edu.backend.entity.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
    Film findByName(String name);
    Film findByFilmId(Integer filmId);

    @Query("select f.films from Film f where f.filmId = :filmId")
    List<Session> findSessionsByIdFilm(@Param("filmId") Integer filmId);
}
