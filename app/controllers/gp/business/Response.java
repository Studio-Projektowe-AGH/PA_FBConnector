package controllers.gp.business;

import controllers.Location;
import controllers.LocationCoordinates;
import controllers.fb.business.AboutResponse;
import controllers.fb.business.Category;
import controllers.fb.business.PictureResponse;

/**
 * Created by Marek on 2015-05-16.
 */
public class Response {
    private String name;
    private String[] category_list;
    private String about;
    private Location location;
    private LocationCoordinates location_coordinates;
    private String website;
    private String[] music_genres;
    private String phone;
    private String picture_url;
    
    public Response() {}

    public Response(AboutResponse about, PictureResponse picture) {
        setName(about.getName());

        Category[] category_list = about.getCategory_list();
        String[] new_category_list = new String[category_list.length];
        for (int i = 0; i < category_list.length; i++) {
            new_category_list[i] = category_list[i].getName();
        }
        setCategory_list(new_category_list);

        setAbout(about.getAbout());

        Location newLocation = new Location();
        newLocation.setCity(about.getLocation().getCity());
        newLocation.setCountry(about.getLocation().getCountry());
        newLocation.setStreet(about.getLocation().getStreet());
        setLocation(newLocation);

        LocationCoordinates coordinates = new LocationCoordinates();
        coordinates.setLatitude(about.getLocation().getLatitude());
        coordinates.setLongitude(about.getLocation().getLongitude());
        setLocation_coordinates(coordinates);

        setWebsite(about.getWebsite());
        setMusic_genres(null);
        setPhone(about.getPhone());
        setPicture_url(picture.getUrl());
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCategory_list() {
        return category_list;
    }

    public void setCategory_list(String[] category_list) {
        this.category_list = category_list;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocationCoordinates getLocation_coordinates() {
        return location_coordinates;
    }

    public void setLocation_coordinates(LocationCoordinates location_coordinates) {
        this.location_coordinates = location_coordinates;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String[] getMusic_genres() {
        return music_genres;
    }

    public void setMusic_genres(String[] music_genres) {
        this.music_genres = music_genres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
}
