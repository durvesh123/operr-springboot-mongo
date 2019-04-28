package com.operr.springboot.operrlocations.repositories;

import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.operr.springboot.operrlocations.models.Location;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface LocationRepository extends MongoRepository<Location, String> {

    Location findBy_id(ObjectId _id);

    @Query("{ 'name' : ?0  }")
    Location getSpecificLocation(String name);

    List<Location> findByPositionWithin(Circle c);

}
