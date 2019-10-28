package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Session;
import com.netcracker.edu.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/time/{time}", method = RequestMethod.GET)
    public ResponseEntity<Session> getSessionByTime(@PathVariable(name = "time") Double time){
        Session session = sessionService.findByTime(time);
        return ResponseEntity.ok(session);
    }

    @RequestMapping(value = "/date/{date}", method = RequestMethod.GET)
    public ResponseEntity<Session> getSessionByDate(@PathVariable(name = "date") Integer date){
        Session session = sessionService.findByDate(date);
        return ResponseEntity.ok(session);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Session>> getAllSessions(){
        List<Session> session = sessionService.findAll();
        return ResponseEntity.ok(session);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Session saveSession(@RequestBody Session session){
        return sessionService.save(session);
    }

    @RequestMapping(value = "/{idSession}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable(name = "idSession") Integer idSession){
        sessionService.delete(idSession);
    }
}
