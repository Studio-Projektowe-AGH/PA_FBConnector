package controllers.fb;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by Marek on 2015-05-11.
 */
public interface Queries {
    JsonNode batched();
    String single();
}
