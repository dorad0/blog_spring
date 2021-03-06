package blog.web.controller;

import blog.service.UserService;
import blog.service.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Secured(value = "ROLE_ANONYMOUS")
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String loadFormPage(Model m) {
        m.addAttribute("userForm", new UserForm());

        return "userRegisterForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@Valid UserForm userForm, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "userRegisterForm";
        }

        service.saveUserFromForm(userForm);
        m.addAttribute("user", userForm);

        return "redirect:/user/" + userForm.getName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable String username, Model model) {
        model.addAttribute(service.findByName(username));

        return "userProfile";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable long id) {
        service.delete(service.findById(id));

        return "deletedUser";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        dateFormat.setLenient(false);

        binder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(
                dateFormat, false));
    }

}
