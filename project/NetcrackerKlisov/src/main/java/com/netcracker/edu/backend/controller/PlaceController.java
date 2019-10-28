package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Place;
import com.netcracker.edu.backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Place> getAllPlace(){
        return placeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Place savePlace(@RequestBody Place place){
        return placeService.save(place);
    }

    @RequestMapping(value = "/{idPlace}", method = RequestMethod.DELETE)
    public void deletePlace(@PathVariable(name = "idPlace") Integer idPlace){
        placeService.delete(idPlace);
    }
}
