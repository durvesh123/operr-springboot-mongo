package com.operr.springboot.operrlocations.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.operr.springboot.operrlocations.models.Location;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

public interface LocationRepository extends MongoRepository<Location, String> {

    Location findBy_id(ObjectId _id);

    @Query(value = "{ 'latitude' : ?0 , 'longitude' : ?0 }")
    Location getLocation(long latitude, long longitude);

}
