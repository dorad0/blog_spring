package blog.web.controller.admin;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/analytics/")
public class AdminAnalyticsController {

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.GET)
    public String mainPage() {
        return "analyticsMain";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "usersRegistration/", method = RequestMethod.GET)
    public String showUserRegistrationChart() {
        return "userRegistrationChart";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "usersCommentsByDay/", method = RequestMethod.GET)
    public String showUserCommentsByDayChart() {
        return "userCommentActivityByDay";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "commentsByUsers/", method = RequestMethod.GET)
    public String showCommentsByUsersChart() {
        return "commentsByUsers";
    }


}
