package controllers.individual.fb;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Marek on 2015-05-16.
 * Mapper for age
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Age {
    private Integer min;
    private Integer max;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
