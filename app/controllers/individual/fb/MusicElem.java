package controllers.individual.fb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Marek on 2015-05-16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MusicElem implements Value {
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String name;

    @Override
    public String getVal() {
        return name;
    }
}
