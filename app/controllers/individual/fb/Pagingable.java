package controllers.individual.fb;

import controllers.fb.Utils;
import play.libs.Json;
import play.libs.ws.WS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Marek on 2015-05-17.
 */
public abstract class Pagingable {
    public String[] download() {
        ArrayList<String> ret = new ArrayList<>();
        Value[] data = getData();
        String next = getPaging().getNext();
        while (true) {
            ret.addAll(Arrays.asList(data).parallelStream().map(this::map)
                    .collect(Collectors.toList()));

            if (next == null)
                break;
            Pagingable f = Json.fromJson(WS.url(next).get().get(5000).asJson(), getaClass());
            data = f.getData();
            next = f.getPaging().getNext();
        }

        return ret.toArray(new String[ret.size()]);
    }

    abstract Class<? extends Pagingable> getaClass();

    protected abstract Paging getPaging();

    abstract public Value[] getData();
    public abstract String map(Value val);
}
