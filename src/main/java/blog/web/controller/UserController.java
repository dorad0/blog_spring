package blog.web.controller;

import blog.model.User;
import blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by user on 20.01.2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String loadFormPage(Model m) {
        m.addAttribute("user", new User());
        return "user/registerForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@Valid User user, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "user/registerForm";
        }

        service.save(user);
        m.addAttribute("user", user);
        return "redirect:/user/" + user.getName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable String username, Model model) {
        model.addAttribute(service.getUser(username));
        return "user/profile";
    }
}
