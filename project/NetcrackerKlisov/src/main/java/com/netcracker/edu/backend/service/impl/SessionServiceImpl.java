package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Film;
import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.entity.Session;
import com.netcracker.edu.backend.repository.HallRepository;
import com.netcracker.edu.backend.repository.PlaceRepository;
import com.netcracker.edu.backend.repository.SessionRepository;
import com.netcracker.edu.backend.repository.TicketRepository;
import com.netcracker.edu.backend.service.SessionService;
import com.netcracker.edu.backend.service.TicketService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private HallRepository hallRepository;

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
    public Session save(Session session) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
        Date currentSessionTime = dateFormat.parse(session.getTime());
        Date endCurrentSessionTime = DateUtils.addMinutes(currentSessionTime, session.getFilm().getTime().intValue() + 15);
        List<Session> sessions = sessionRepository.findHalls(session.getHall().getIdHall(), session.getDate());
        if (!sessions.isEmpty()) {
                for (Session sess: sessions) {
                    try {
                        Date sessionTime = dateFormat.parse(sess.getTime());
                        Date targetTime = DateUtils.addMinutes(sessionTime, sess.getFilm().getTime().intValue() + 15);
                        if (endCurrentSessionTime.compareTo(sessionTime) < 0) {
                            return sessionRepository.save(session);
                        } else if (currentSessionTime.compareTo(targetTime) > 0) {
                            return sessionRepository.save(session);
                        }
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                }
                return null;
        }
        return sessionRepository.save(session);
    }

    @Override
    public void delete(Integer idSession){
        Session session = sessionRepository.findByIdSession(idSession);
        session.getTickets().forEach(ticket -> ticketService.delete(ticket.getIdTicket()));
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

    @Override
    public Film findFilmByIdSession(Integer idSession) {
        return sessionRepository.findFilmByIdSession(idSession);
    }
}
