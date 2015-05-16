package controllers.fb;

/**
 * Created by Marek on 2015-05-14.
 */
public class QueryFactory {
    private static QueryFactory factory = null;

    public static QueryFactory getFactory() {
        if (factory == null) {
            factory = new QueryFactory();
        }
        return factory;
    }

    private QueryFactory() {

    }

    public Query get(String relative_url) {
        Query query = new Query();
        query.setMethod("GET");
        query.setRelative_url(relative_url);

        return query;
    }
}
