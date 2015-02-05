package blog.web.controller;

import blog.service.UserService;
import blog.service.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

        m.addAttribute("userForm", new UserForm());
        return "user/registerForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@Valid UserForm userForm, BindingResult result, Model m) {

        if (result.hasErrors()) {
            return "user/registerForm";
        }

        service.save(userForm);
        m.addAttribute("user", userForm);
        return "redirect:/user/" + userForm.getName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable String username, Model model) {

        model.addAttribute(service.getUser(username));
        return "user/profile";
    }
}
