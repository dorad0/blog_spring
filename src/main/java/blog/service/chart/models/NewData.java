package blog.service.chart.models;

import java.util.Date;
import java.util.List;

/**
 * Created by user_1 on 12/31/2015.
 */
public class NewData {
    List<String> labels;
    List<String> data;

    public NewData() {
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
