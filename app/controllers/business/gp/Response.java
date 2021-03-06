package controllers.business.gp;

import com.fasterxml.jackson.annotation.JsonInclude;
import controllers.Location;
import controllers.LocationCoordinates;
import controllers.business.fb.Category;
import controllers.business.fb.FbLocation;
import controllers.business.fb.Picture;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Marek on 2015-05-16.
 * GoParty response model
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public Response(controllers.business.fb.Response response) {
        name = response.getName();
        Category[] category_list = response.getCategory_list();
        if (category_list != null) {
            List<Category> categories = Arrays.asList(response.getCategory_list());
            this.category_list = categories.parallelStream().map(Category::getName).toArray(String[]::new);
        }
        about = response.getAbout();
        FbLocation fbLocation = response.getLocation();
        if (fbLocation != null) {
            location = new Location(fbLocation);
            location_coordinates = new LocationCoordinates(fbLocation);
        }
        website = response.getWebsite();
        music_genres = null;
        phone = response.getPhone();
        Picture picture = response.getPicture();
        if (picture != null) {
            picture_url = picture.getData().getUrl();
        }
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
