package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.business.gp.Response;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSRequestHolder;
import play.libs.ws.WSResponse;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Application extends Controller {

    private static final long TIMEOUT = 60000;
    private static final String FB_TOKEN = "fbToken";
    private static final String GP_TOKEN = "gpToken";
    private static final HashSet<String> REQUIRED = new HashSet<>(Arrays.asList(FB_TOKEN, GP_TOKEN));

    @BodyParser.Of(BodyParser.FormUrlEncoded.class)
    public static Result business() {
        String fields = "name,category_list{name},about,location{country,city,street,latitude,longitude}," +
                "website,phone,picture.type(large){url}";

        Map<String, String[]> params = request().body().asFormUrlEncoded();

        if (!REQUIRED.parallelStream().allMatch(params::containsKey)) {
            REQUIRED.removeAll(params.keySet());

            return badRequest(Arrays.toString(REQUIRED.toArray()) + " fields is required");
        }

        WSResponse update = getUpdate(fields, params);

        if (update.getStatus() != 200) {
            return internalServerError("Facebook sie wykrzaczyl:<br/>" + update.asJson());
        }

        JsonNode responseJson = update.asJson();

        controllers.business.fb.Response fbResponse =
                Json.fromJson(responseJson, controllers.business.fb.Response.class);
        JsonNode response = Json.toJson(new Response(fbResponse));
        String role = "business";
        String gpToken = params.get(GP_TOKEN)[0];

        return sendUpdate(response, role, gpToken);
    }

    public static Result individual() {
        String fields = "id,first_name,last_name,age_range,friends{id},music{category,name},picture.type(large){url}";
        Map<String, String[]> params = request().body().asFormUrlEncoded();

        if (!REQUIRED.parallelStream().allMatch(params::containsKey)) {
            REQUIRED.removeAll(params.keySet());

            return badRequest(Arrays.toString(REQUIRED.toArray()) + " fields is required");
        }

        WSResponse update = getUpdate(fields, params);

        if (update.getStatus() != 200) {
            return internalServerError("Facebook sie wykrzaczyl:<br/>" + update.asJson());
        }

        JsonNode responseJson = update.asJson();

        controllers.individual.fb.Response fbResponse =
                Json.fromJson(responseJson, controllers.individual.fb.Response.class);
        JsonNode response = Json.toJson(new controllers.individual.gp.Response(fbResponse));
        String role = "individual";
        String gpToken = params.get(GP_TOKEN)[0];

        return sendUpdate(response, role, gpToken);
    }

    private static Result sendUpdate(JsonNode response, String role, String gpToken) {
        WSResponse psResponse = WS.url("https://goparty-profile.herokuapp.com/profiles/" + role + "/" + gpToken)
                .post(response)
                .get(TIMEOUT);

        ObjectNode responses = Json.newObject();
        responses.put("request", response);
        responses.put("response", new String(psResponse.asByteArray()));
        return status(psResponse.getStatus(), responses);
    }

    private static WSResponse getUpdate(String fields, Map<String, String[]> params) {
        WSRequestHolder info = WS.url("https://graph.facebook.com/me")
//        WSRequestHolder info = WS.url("https://graph.facebook.com/116544511698923")
//        WSRequestHolder info = WS.url("https://graph.facebook.com/126260014251")
                .setQueryParameter("access_token", params.get(FB_TOKEN)[0])
                .setQueryParameter("locale", "pl_PL")
                .setQueryParameter("fields", fields);

        return info.get().get(TIMEOUT);
    }
}
