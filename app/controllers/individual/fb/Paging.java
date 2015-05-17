package controllers.individual.fb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Marek on 2015-05-16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paging {
    private String next;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
