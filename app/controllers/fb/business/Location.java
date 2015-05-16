package controllers.fb.business;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marek on 2015-05-16.
 */
public class Location {
//    @JsonProperty("country")
    private String country;
//    @JsonProperty("city")
    private String city;
//    @JsonProperty("street")
    private String street;
//    @JsonProperty("latitude")
    private String latitude;
//    @JsonProperty("longitude")
    private String longitude;

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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
