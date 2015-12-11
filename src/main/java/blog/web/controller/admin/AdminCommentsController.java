package blog.web.controller.admin;

import blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user_1 on 11/30/2015.
 */
@Controller
@RequestMapping(value = "/admin/comments")
public class AdminCommentsController {

    @Autowired
    private CommentService commentService;

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String getUserComments(@PathVariable String username, Model model) {


        model.addAttribute("comments", commentService.getUserComments(username));

        return "userComments";
    }
}
