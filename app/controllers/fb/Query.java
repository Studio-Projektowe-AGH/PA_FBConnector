package controllers.fb;

/**
 * Created by Marek on 2015-05-14.
 */
public class Query {
    private String method;
    private String relative_url;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRelative_url() {
        return relative_url;
    }

    public void setRelative_url(String relative_url) {
        this.relative_url = relative_url;
    }
}
