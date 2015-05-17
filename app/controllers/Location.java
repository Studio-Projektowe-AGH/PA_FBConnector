package controllers;

import controllers.business.fb.FbLocation;

/**
 * Created by Marek on 2015-05-16.
 */
public class Location {
    private String country;
    private String city;
    private String street;

    public Location(FbLocation fbLocation) {
        country = fbLocation.getCountry();
        city = fbLocation.getCity();
        street = fbLocation.getStreet();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
