package blog.web.controller.admin;

import blog.service.UserService;
import blog.service.chart.models.Data;
import blog.service.chart.models.DataSet;
import blog.service.chart.models.NewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user_1 on 12/24/2015.
 */
@RestController
@RequestMapping("chart/")
public class ChartRestController {

    @Autowired
    UserService userService;

    @RequestMapping(value="data/", method = RequestMethod.GET)
    public Data getShopInJSON() {

        Data data = new Data();
        List<DataSet> dataSets = new ArrayList<>();
        dataSets.add(new DataSet());
        data.setDatasets(dataSets);
        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("May");
        labels.add("June");
        labels.add("March");
        data.setLabels(labels);

        return data;

    }

    @RequestMapping(value = "userRegistrationData/", method = RequestMethod.GET)
    public NewData getUserRegisterChartData() {

       return userService.getUsersRegisterData();
    }


}
