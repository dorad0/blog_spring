package blog.web.controller.admin;

import blog.entity.Article;
import blog.entity.User;
import blog.service.ArticleService;
import blog.service.CommentService;
import blog.service.UserService;
import blog.service.forms.CommentForm;
import org.hibernate.persister.entity.Loadable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by user_1 on 11/27/2015.
 */
@Controller
@RequestMapping(value = "/admin/article")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id);
        if (article != null) {
            model.addAttribute("article", article);
            model.addAttribute("comments", commentService.getArticleComments(id));
//            model.addAttribute("commentForm", new CommentForm());
//            model.addAttribute("dates", articleService.getDates());

            return "adminArticleComments";
        } else {
            return "adminNoArticle";
        }
    }
}

