package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.entity.Session;
import com.netcracker.edu.backend.repository.SessionRepository;
import com.netcracker.edu.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> findAll(){
        return (List<Session>) sessionRepository.findAll();
    }

    @Override
    public Session findByDate(Integer date){
        return sessionRepository.findByDate(date);
    }

    @Override
    public Session findByTime(Double time){
        return sessionRepository.findByTime(time);
    }

    @Override
    public Session save(Session session){
        return sessionRepository.save(session);
    }

    @Override
    public void delete(Integer idSession){
        sessionRepository.deleteById(idSession);
    }

    @Override
    public Hall findHall(Integer idSession){
        return sessionRepository.findHall(idSession);
    }

    @Override
    public List<Place> findSessionPlace(Integer idSession){
        return sessionRepository.findSessionPlace(idSession);
    }

    @Override
    public Session findByIdSession(Integer idSession){
        return sessionRepository.findByIdSession(idSession);
    }
}
