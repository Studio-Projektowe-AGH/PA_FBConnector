package controllers.fb.individual;

/**
 * Created by Marek on 2015-05-16.
 */
public class AboutResponse {
    private String id;
    private String first_name;
    private String last_name;
    private Age age_range;

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
}
