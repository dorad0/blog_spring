package blog.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alex on 5/18/2015.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.GET)
    public String getAdminPage() {
        return "adminPage";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String getArticles() {
        return "adminArticles";
    }
}
