package controllers.fb.business;

/**
 * Created by Marek on 2015-05-16.
 */

//@Entit
public class AboutResponse {
//    @JsonProperty("name")
    private String name;
//    @JsonProperty("category_list")
    private Category[] category_list;
//    @JsonProperty("about")
    private String about;
//    @JsonProperty("location")
    private Location location;
//    @JsonProperty("website")
    private String website;
//    @JsonProperty("phone")
    private String phone;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    private String id;
}
