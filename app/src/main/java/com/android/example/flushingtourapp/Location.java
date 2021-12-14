package com.android.example.flushingtourapp;

public class Location {

    private String name;
    private String description;
    private int image;
    private String link;
    private String location;
    private String phone;

    //constructor for the object
    public Location(String name, String description, int image, String link, String location, String phone) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.link = link;
        this.location = location;
        this.phone = phone;
    }

    //getters for each attribute
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }
}
