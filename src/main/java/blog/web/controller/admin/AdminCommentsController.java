package blog.web.controller.admin;

import blog.entity.Article;
import blog.service.ArticleService;
import blog.service.CommentService;
import blog.service.forms.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by user_1 on 11/30/2015.
 */
@Controller
@RequestMapping(value = "/admin/comments")
public class AdminCommentsController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String getUserComments(@PathVariable String username, Model model) {


        model.addAttribute("comments", commentService.getUserComments(username));

        return "userComments";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/{id}")
    public String getArticleWithComments(@PathVariable long id, Model model) {
        Article article = articleService.findById(id);
        if (article != null) {
            model.addAttribute("article", article);
            model.addAttribute("comments", commentService.getArticleComments(id));
            model.addAttribute("commentForm", new CommentForm());
            model.addAttribute("dates", articleService.getDates());

            return "adminArticleComments";
        } else {
            return "adminNoArticle";
        }
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/add/{articleId}", method = RequestMethod.POST)
    public String addComment(@Valid CommentForm commentForm, @PathVariable long articleId, BindingResult result) {
        if (result.hasErrors()) {
            return "adminArticleComments";
        }

        commentService.save(commentForm);

        return "redirect:/admin/comments/" + articleId + "#end";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteComment(@RequestParam(required = true) long commentId, @RequestParam(required = true) long articleId) {
        commentService.delete(commentId);

        return "redirect:/admin/comments/" + articleId;
    }
}
