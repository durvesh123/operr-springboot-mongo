package com.operr.springboot.operrlocations;

import com.operr.springboot.operrlocations.models.Location;
import javafx.scene.shape.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.operr.springboot.operrlocations.repositories.LocationRepository;

import org.bson.types.ObjectId;
import javax.validation.Valid;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/operr")
public class RestController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    public Location createLocation(@Valid @RequestBody Location location) {
        location.set_id(ObjectId.get());
        locationRepository.save(location);
        return location;
    }

    @RequestMapping(value = "/updateLocation/{id}", method = RequestMethod.PUT)
    public void modifyLocationById(@PathVariable("id") ObjectId id, @Valid @RequestBody Location location) {
        location.set_id(id);
        locationRepository.save(location);
    }

    @RequestMapping(value = "/deleteLocation/{id}", method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable ObjectId id) {
        locationRepository.delete(locationRepository.findBy_id(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Location getLocationByID(@PathVariable("id") ObjectId id) {
        return locationRepository.findBy_id(id);
    }

    @RequestMapping(value = "/getSpecificLocation", method = RequestMethod.GET)
    public Location getSpecificLocation(@Valid @RequestBody Location location) {
        return locationRepository.getSpecificLocation(location.getName());
    }

    @RequestMapping(value = "/getNearByLocations/{radius}, method = RequestMethod.GET")
    public List<Location> getNearbyLocations(@Valid @RequestBody Location location, @PathVariable("radius") Long radius) {
        return locationRepository.getNearbyLocations(location.getLatitude(), location.getLongitude(), radius);
    }

}
