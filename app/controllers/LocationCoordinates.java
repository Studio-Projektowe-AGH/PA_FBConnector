package controllers;

import controllers.business.fb.FbLocation;

/**
 * Created by Marek on 2015-05-16.
 */
public class LocationCoordinates {
    private Float latitude;
    private Float longitude;

    public LocationCoordinates(FbLocation fbLocation) {
        latitude = fbLocation.getLatitude();
        longitude = fbLocation.getLongitude();
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
