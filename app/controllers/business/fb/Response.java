package controllers.business.fb;

/**
 * Created by Marek on 2015-05-16.
 */
public class Response {
    private String name;
    private Category[] category_list;
    private String about;
    private FbLocation location;
    private String website;
    private String phone;
    private Picture picture;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category[] getCategory_list() {
        return category_list;
    }

    public void setCategory_list(Category[] category_list) {
        this.category_list = category_list;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public FbLocation getLocation() {
        return location;
    }

    public void setLocation(FbLocation location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
