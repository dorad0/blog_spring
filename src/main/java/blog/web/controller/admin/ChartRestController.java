package blog.web.controller.admin;

import blog.service.UserService;
import blog.service.chart.models.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user_1 on 12/24/2015.
 */
@RestController
@RequestMapping("chart/")
public class ChartRestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "userRegistrationData/", method = RequestMethod.GET)
    public ChartData getUserRegisterChartData() {

       return userService.getUsersRegisterData();
    }

    @RequestMapping(value = "commentsActivity/", method = RequestMethod.GET)
    public ChartData getCommentsActivity() {

        return userService.getCommentsActivity();
    }

    @RequestMapping(value = "usersComments/")
    public ChartData getUsersComments() {
        return userService.getUsersComment();
    }

}
