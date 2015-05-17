package controllers.individual.fb;

import controllers.fb.Utils;
import play.libs.Json;
import play.libs.ws.WS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Marek on 2015-05-16.
 */
public class Friends extends Pagingable {
    private Response[] data;
    private Paging paging;
    private Summary summary;

    @Override
    public Response[] getData() {
        return data;
    }

    @Override
    public String map(Value val) {
        return Utils.fb2gp(val.getVal());
    }

    public void setData(Response[] data) {
        this.data = data;
    }

    @Override
    Class<? extends Pagingable> getaClass() {
        return Friends.class;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

}
