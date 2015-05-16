package controllers.fb.business;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marek on 2015-05-16.
 */
public class Category {
//    @JsonProperty("name")
    private String name;
//    @JsonProperty("if")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
