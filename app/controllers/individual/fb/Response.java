package controllers.individual.fb;

import controllers.business.fb.Picture;

/**
 * Created by Marek on 2015-05-16.
 */
public class Response implements Value {
    private String id;
    private String first_name;
    private String last_name;
    private Age age_range;
    private Friends friends;
    private Music music;
    private Picture picture;

    public Friends getFriends() {
        return friends;
    }

    public void setFriends(Friends friends) {
        this.friends = friends;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String getVal() {
        return getId();
    }
}
