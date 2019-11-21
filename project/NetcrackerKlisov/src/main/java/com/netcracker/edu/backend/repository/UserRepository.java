package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Ticket;
import com.netcracker.edu.backend.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);

    @Query("select u.tickets from User u where u.idUser = :idUser")
    List<Ticket> findTicketByIdUser(@Param("idUser") Integer idUser);

    @Query("select u.tickets from User u where u.login = :login")
    List<Ticket> findTicketByLogin(@Param("login") String login);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :password where u.idUser = :idUser")
    void updatePassword(@Param("idUser") Integer idUser, @Param("password") String password);
}
