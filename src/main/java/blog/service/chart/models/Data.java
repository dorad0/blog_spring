package blog.service.chart.models;

import java.util.List;

/**
 * Created by user_1 on 12/24/2015.
 */
public class Data {
    List<String> labels;
    List<DataSet> datasets;

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<DataSet> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<DataSet> datasets) {
        this.datasets = datasets;
    }
}
