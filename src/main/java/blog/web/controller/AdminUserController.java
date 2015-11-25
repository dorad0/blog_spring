package blog.web.controller;

import blog.service.ArticleService;
import blog.service.CommentService;
import blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user_1 on 11/25/2015.
 */
@Controller
@RequestMapping(value = "/admin/user/")
public class AdminUserController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable long id) {
        userService.delete(userService.findById(id));

        return "deletedUser";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable String username, Model model) {
        model.addAttribute(userService.findByName(username));

        return "adminUserProfile";
    }

}
