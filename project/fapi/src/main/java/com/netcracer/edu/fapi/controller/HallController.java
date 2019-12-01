package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Hall;
import com.netcracer.edu.fapi.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hall")
public class HallController {

    @Autowired
    private HallService hallService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Hall> getHallAll(){
        return hallService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public Hall saveHall(@RequestBody Hall hall){
        return hallService.save(hall);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{idHall}", method = RequestMethod.DELETE)
    public void deleteHall(@PathVariable(name = "idHall")Integer idHall){
        hallService.delete(idHall);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Hall> getHallByName(@PathVariable(name = "name") String name){
        Hall hall = hallService.findByName(name);
        return ResponseEntity.ok(hall);
    }
}
