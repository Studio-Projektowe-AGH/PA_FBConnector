package controllers;

import controllers.fb.GET;
import controllers.fb.Queries;
import play.libs.ws.WS;
import play.libs.ws.WSRequestHolder;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.*;

public class Application extends Controller {

    private static final long TIMEOOUT = 5000;
    private static final ArrayList<String> REQUIRED = new ArrayList<>(Collections.singletonList("token"));
    private static final ArrayList<String> SUPPORTED = new ArrayList<>(Arrays.asList(
            "birthday","gender","installed","picture"
    ));

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result user() {//String token, String fields, String id) {
        Map<String, String[]> params = request().body().asFormUrlEncoded();

        if (!REQUIRED.parallelStream().allMatch(params::containsKey)) {
            return badRequest(Arrays.toString(REQUIRED.toArray()) + " parameters are required");
        }

        String id = takeParam(params, "id", "me");
        WSRequestHolder holder = WS.url("https://graph.facebook.com/" + id)
                .setQueryParameter("access_token", params.get("token")[0]);


        String fields = takeParam(params, "fields", "birthday,gender,installed");
        HashSet<String> strings = new HashSet<>(Arrays.asList(fields.split(",")));
        if (!SUPPORTED.parallelStream().allMatch(strings::contains)) {
            strings.removeAll(SUPPORTED);
            return badRequest(Arrays.toString(strings.toArray()) + " fields are not supported");
        }

        ArrayList<Queries> queries = new ArrayList<>();
        if (strings.remove("photo")) {
            queries.add(new GET(id + "/picture?redirect=false"));
        }

        holder = holder.setQueryParameter("fields", fields);
        WSResponse wsResponse = holder.get().get(TIMEOOUT);
        return ok(wsResponse.asByteArray());
//
//        F.Promise<F.Either<WSResponse, WSResponse>> eitherPromise = holder.get().or(user.get());
//
//        F.Either<WSResponse, WSResponse> asd = eitherPromise.get(25000);
//
//        if (asd.left.isDefined())
//            return ok(new String(asd.left.get().asByteArray()));
//        else
//            return ok(new String(asd.right.get().asByteArray()));
    }

    private static String takeParam(Map<String, String[]> params, String parameter, String def) {
        String[] param;
        return (param = params.get(parameter)) == null ? def : param[0];
    }

    public static Result mongo(String user) {
        return ok("dupa");
    }
}
