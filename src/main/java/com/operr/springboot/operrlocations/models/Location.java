package com.operr.springboot.operrlocations.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Location {

    @Id
    private ObjectId _id;
    private Long latitude;
    private Long longitude;
    private String name;

    public Location () {

    }

    public Location(ObjectId _id, Long latitude, Long longitude, String name) {
        this._id = _id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
