package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.fb.business.AboutResponse;
import controllers.fb.business.PictureResponse;
import controllers.fb.QueryFactory;
import controllers.gp.business.Response;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSRequestHolder;
import play.libs.ws.WSResponse;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Application extends Controller {

    private static final long TIMEOUT = 5000;
    private static final String FB_TOKEN = "fbToken";
    private static final String GP_TOKEN = "gpToken";
    private static final HashSet<String> REQUIRED = new HashSet<>(Arrays.asList(FB_TOKEN, GP_TOKEN));

    @BodyParser.Of(BodyParser.FormUrlEncoded.class)
    public static Result business() {
        Map<String, String[]> params = request().body().asFormUrlEncoded();

        if (!REQUIRED.parallelStream().allMatch(params::containsKey)) {
            badRequest(REQUIRED.removeAll(params.keySet()) + " fields is required");
        }

        WSRequestHolder info = WS.url("https://graph.facebook.com/")
                .setQueryParameter("access_token", params.get(FB_TOKEN)[0])
                .setQueryParameter("locale", "pl_PL")
                .setQueryParameter("include_headers", "false");

        ArrayList<Object> queries = new ArrayList<>();
        QueryFactory queryFactory = QueryFactory.getFactory();

        queries.add(queryFactory.get(
                "me?fields=name,category_list{name},about," +
                        "location{country,city,street,latitude,longitude},website,phone"
        ));
        queries.add(queryFactory.get(
                "me/picture?type=large&redirect=false"
        ));

        info.setQueryParameter("batch", Json.toJson(queries).toString());

        WSResponse wsResponse = info.post("").get(TIMEOUT);

        JsonNode responseJson = wsResponse.asJson();

        for (JsonNode node : responseJson) {
            if (node.get("code").asInt() != 200) {
                return internalServerError("FB hasn't responded with 200 code on node " + node.toString());
            }
        }

        AboutResponse   about   = Json.fromJson(Json.parse(responseJson.get(0).get("body").asText()), AboutResponse.class);
        PictureResponse picture = Json.fromJson(Json.parse(responseJson.get(1).get("body").asText()).get("data"), PictureResponse.class);
        Response response = new Response(about, picture);



        return ok(Json.toJson(response));
    }

    public static Result indyvidual() {
        Map<String, String[]> params = request().body().asFormUrlEncoded();

        if (!REQUIRED.parallelStream().allMatch(params::containsKey)) {
            badRequest(REQUIRED.removeAll(params.keySet()) + " fields is required");
        }

        WSRequestHolder info = WS.url("https://graph.facebook.com/")
                .setQueryParameter("access_token", params.get(FB_TOKEN)[0])
                .setQueryParameter("locale", "pl_PL")
                .setQueryParameter("include_headers", "false");

        ArrayList<Object> queries = new ArrayList<>();
        QueryFactory queryFactory = QueryFactory.getFactory();

        queries.add(queryFactory.get("me?fields=id,first_name,last_name,age_range"));
        queries.add(queryFactory.get("me?friends"));
        queries.add(queryFactory.get("me?friends"));
        queries.add(queryFactory.get("me/picture?type=large&redirect=false"));

        info.setQueryParameter("batch", Json.toJson(queries).toString());

        WSResponse wsResponse = info.post("").get(TIMEOUT);

        JsonNode responseJson = wsResponse.asJson();

        for (JsonNode node : responseJson) {
            if (node.get("code").asInt() != 200) {
                return internalServerError("FB hasn't responded with 200 code on node " + node.toString());
            }
        }

        AboutResponse   about   = Json.fromJson(Json.parse(responseJson.get(0).get("body").asText()), AboutResponse.class);
        PictureResponse picture = Json.fromJson(Json.parse(responseJson.get(1).get("body").asText()).get("data"), PictureResponse.class);
        Response response = new Response(about, picture);



        return ok(Json.toJson(response));
    }
}
