package blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user_1 on 1/5/2016.
 */
@Controller
@RequestMapping(value = "/admin/analytics/")
public class AdminAnalyticsController {

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage() {
        return "analyticsMain";
    }

    @RequestMapping(value = "usersRegistration/", method = RequestMethod.GET)
    public String showUserRegistrationChart() {
        return "userRegistrationChart";
    }


}
