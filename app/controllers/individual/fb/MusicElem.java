package controllers.individual.fb;

/**
 * Created by Marek on 2015-05-16.
 */
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
