package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Session;

import java.util.List;

public interface SessionService {
    Session findByDate(Integer date);
    Session findByTime(Double time);
    public List<Session> findAll();
    Session save(Session session);
    void delete(Integer idSession);
}
