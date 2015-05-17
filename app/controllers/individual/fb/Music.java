package controllers.individual.fb;

/**
 * Created by Marek on 2015-05-16.
 */
public class Music extends Pagingable {
    private MusicElem data[];
    private Paging paging;

    public MusicElem[] getData() {
        return data;
    }

    @Override
    public String map(Value val) {
        return val.getVal();
    }

    public void setData(MusicElem[] data) {
        this.data = data;
    }

    @Override
    Class<? extends Pagingable> getaClass() {
        return Music.class;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
