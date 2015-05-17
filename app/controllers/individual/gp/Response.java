package controllers.individual.gp;

import controllers.individual.fb.Age;

/**
 * Created by Marek on 2015-05-16.
 */
public class Response {
    private SocialId social_id;
    private String first_name;
    private String last_name;
    private Age age_range;
    private String[] friend_list;
    private String[] favourite_genres;
    private String[] favourite_bands;
    private String picture_url;

    public Response() {}

    public Response(controllers.individual.fb.Response response) {
        social_id = new SocialId(response.getId());
        first_name = response.getFirst_name();
        last_name = response.getLast_name();
        age_range = response.getAge_range();
        friend_list = response.getFriends().download();
        favourite_bands = null;
        picture_url = response.getPicture().getData().getUrl();
    }

    public SocialId getSocial_id() {
        return social_id;
    }

    public void setSocial_id(SocialId social_id) {
        this.social_id = social_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Age getAge_range() {
        return age_range;
    }

    public void setAge_range(Age age_range) {
        this.age_range = age_range;
    }

    public String[] getFriend_list() {
        return friend_list;
    }

    public void setFriend_list(String[] friend_list) {
        this.friend_list = friend_list;
    }

    public String[] getFavourite_genres() {
        return favourite_genres;
    }

    public void setFavourite_genres(String[] favourite_genres) {
        this.favourite_genres = favourite_genres;
    }

    public String[] getFavourite_bands() {
        return favourite_bands;
    }

    public void setFavourite_bands(String[] favourite_bands) {
        this.favourite_bands = favourite_bands;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
}
