package blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alex on 5/18/2015.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    public String getAdminPage() {
        return "adminPage";
    }
}
