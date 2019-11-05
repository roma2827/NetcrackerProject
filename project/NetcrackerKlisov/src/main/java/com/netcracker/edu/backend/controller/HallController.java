package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Hall;
import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(method = RequestMethod.POST)
    public Hall saveHall(@RequestBody Hall hall){
        return hallService.save(hall);
    }

    @RequestMapping(value = "/delete/{idHall}", method = RequestMethod.DELETE)
    public void deleteHall(@PathVariable(name = "idHall")Integer idHall){
        hallService.delete(idHall);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Hall> hetHallByName(@PathVariable(name = "name") String name){
        Hall hall = hallService.findByName(name);
        return ResponseEntity.ok(hall);
    }

//    @RequestMapping(value = "/places/{idHall}", method = RequestMethod.GET)
//    public ResponseEntity<List<Place>> getPlaces(@PathVariable(name = "idHall") Integer idHall){
//        List<Place> places = hallService.findPlacesByIdHall(idHall);
//        return ResponseEntity.ok(places);
//    }
}
