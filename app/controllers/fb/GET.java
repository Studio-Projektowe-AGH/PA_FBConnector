package controllers.fb;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.fb.Queries;

/**
 * Created by Marek on 2015-05-11.
 */
public class GET implements Queries {
    private final String content;

    public GET(String content) {
        this.content = content;
    }

    @Override
    public JsonNode batched() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.put("method", "GET");
        rootNode.put("relative_url", content);

        return rootNode;
    }

    @Override
    public String single() {
        return null;
    }
}
