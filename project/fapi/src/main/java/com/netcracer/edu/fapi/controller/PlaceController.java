package com.netcracer.edu.fapi.controller;

import com.netcracer.edu.fapi.models.Place;
import com.netcracer.edu.fapi.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
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

    @RequestMapping(value = "/update-place", method = RequestMethod.POST)
    public void updatePlaceIsFree(@RequestBody Integer idPlace){
        placeService.updatePlaceIsFree(idPlace);
    }

    @RequestMapping(value = "/{idPlace}", method = RequestMethod.GET)
    public ResponseEntity<Place> getPlaceById(@PathVariable(name = "idPlace") Integer idPlace) {
        Place place = placeService.findByIdPlace(idPlace);
        return ResponseEntity.ok(place);
    }
}
