package controllers.individual.gp;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Marek on 2015-05-16.
 * Mapper for sid
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SocialId {
    private String social_name;
    private String social_id;

    public SocialId(String id) {
        social_name = "facebook";
        social_id = id;
    }

    public String getSocial_name() {
        return social_name;
    }

    public void setSocial_name(String social_name) {
        this.social_name = social_name;
    }

    public String getSocial_id() {
        return social_id;
    }

    public void setSocial_id(String social_id) {
        this.social_id = social_id;
    }
}
