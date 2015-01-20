package blog.web.controller;

import blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by user on 20.01.2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value="/form", method= RequestMethod.GET)
    public String loadFormPage(Model m) {
        m.addAttribute("user", new User());
        return "user/addUser";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String submitForm(@Valid User user, BindingResult result, Model m) {
        if(result.hasErrors()) {
            return "user/addUser";
        }

        m.addAttribute("message", "Successfully saved person: " + user.toString());
        return "user/addUser";
    }
}
