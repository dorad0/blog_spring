package blog.service.chart.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user_1 on 12/30/2015.
 */
public class DataSet {
    String label;
    String fillColor;
    String strokeColor;
    String pointColor;
    String pointStrokeColor;
    String pointHighlightFill;
    String pointHighlightStroke;
    List<Integer> data;

    public DataSet() {
        label = "My First dataset";
        data = new ArrayList<Integer>();
        fillColor = "rgba(220,220,220,0.2)";
        strokeColor = "rgba(220,220,220,1)";
        pointColor = "rgba(220,220,220,1)";
        pointStrokeColor = "#fff";
        pointHighlightFill = "#fff";
        pointHighlightStroke = "rgba(220,220,220,1)";
        data.add(65);
        data.add(59);
        data.add(80);
        data.add(81);
        data.add(56);

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getPointColor() {
        return pointColor;
    }

    public void setPointColor(String pointColor) {
        this.pointColor = pointColor;
    }

    public String getPointStrokeColor() {
        return pointStrokeColor;
    }

    public void setPointStrokeColor(String pointStrokeColor) {
        this.pointStrokeColor = pointStrokeColor;
    }

    public String getPointHighlightFill() {
        return pointHighlightFill;
    }

    public void setPointHighlightFill(String pointHighlightFill) {
        this.pointHighlightFill = pointHighlightFill;
    }

    public String getPointHighlightStroke() {
        return pointHighlightStroke;
    }

    public void setPointHighlightStroke(String pointHighlightStroke) {
        this.pointHighlightStroke = pointHighlightStroke;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public List<Integer> getData() {

        return data;
    }
}
