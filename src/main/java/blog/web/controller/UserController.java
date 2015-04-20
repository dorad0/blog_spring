package blog.web.controller;

import blog.service.user.UserManager;
import blog.service.user.web.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    private UserManager service;

    @Secured(value = "ROLE_ANONYMOUS")
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
        service.saveUserFromForm(userForm);
        m.addAttribute("user", userForm);
        return "redirect:/user/" + userForm.getName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable String username, Model model) {
        model.addAttribute(service.findByName(username));
        return "user/profile";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable long id) {
        service.delete(id);
        return "user/deletedUser";
    }
}
