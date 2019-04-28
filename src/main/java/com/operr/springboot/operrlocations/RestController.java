package com.operr.springboot.operrlocations;

import com.operr.springboot.operrlocations.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.operr.springboot.operrlocations.repositories.LocationRepository;

import org.bson.types.ObjectId;
import javax.validation.Valid;
import java.util.List;
import org.springframework.data.geo.Circle;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/operr")
public class RestController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    /**
     * @param location
     * api to add a location to mongo collection
     * @return
     */
    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    public Location createLocation(@Valid @RequestBody Location location) {
        location.set_id(ObjectId.get());
        locationRepository.save(location);
        return location;
    }

    /**
     * @param id
     * api to update a document inside a mongo collection
     * @param location
     */
    @RequestMapping(value = "/updateLocation/{id}", method = RequestMethod.PUT)
    public void modifyLocationById(@PathVariable("id") ObjectId id, @Valid @RequestBody Location location) {
        location.set_id(id);
        locationRepository.save(location);
    }

    /**
     * @param id
     * api to delete a collection by it's id inside a mongo collection
     */
    @RequestMapping(value = "/deleteLocation/{id}", method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable ObjectId id) {
        locationRepository.delete(locationRepository.findBy_id(id));
    }

    /**
     * @return all documents of location collection in mongo
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    /**
     * @param id
     * @return location collection by it's id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Location getLocationByID(@PathVariable("id") ObjectId id) {
        return locationRepository.findBy_id(id);
    }

    /**
     * @param location
     * @return location collection by name in mongo
     */
    @RequestMapping(value = "/getSpecificLocation", method = RequestMethod.GET)
    public Location getSpecificLocation(@Valid @RequestBody Location location) {
        return locationRepository.getSpecificLocation(location.getName());
    }

    /**
     * @param location
     * @param radius
     * @return return a list of all location documents within radius inside mongo collection
     */
    @RequestMapping(value = "/getNearByLocations/{radius}, method = RequestMethod.GET")
    public List<Location> getNearbyLocations(@Valid @RequestBody Location location, @PathVariable("radius") Long radius) {
        return locationRepository.findByPositionWithin(new Circle(location.getLatitude(), location.getLongitude(), radius) );
    }

}
