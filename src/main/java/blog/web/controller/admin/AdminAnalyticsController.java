package blog.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "usersCommentsByDay/", method = RequestMethod.GET)
    public String showUserCommentsByDayChart() {
        return "userCommentActivityByDay";
    }

    @RequestMapping(value = "commentsByUsers/", method = RequestMethod.GET)
    public String showCommentsByUsersChart() {
        return "commentsByUsers";
    }


}
