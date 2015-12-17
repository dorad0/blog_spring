package blog.web.controller.admin;

import blog.entity.Article;
import blog.service.ArticleService;
import blog.service.CommentService;
import blog.service.UserService;
import blog.service.forms.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;


    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.GET)
    public String getAdminPage(Model model) {
//        model.addAttribute("articles", articleService.findAll());
        return "adminPage";
    }

//    @Secured(value = "ROLE_ADMIN")
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String getMainPage() {
//        return "adminPage";
//    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/articlesByTitle", method = RequestMethod.GET)
    public String getArticlesByTitle(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "adminArticleTitles";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "adminUsers";
    }

    @RequestMapping("/article/{id}")
    public String getArticleWithComments(@PathVariable long id, Model model) {
        Article article = articleService.findById(id);
        if (article != null) {
            model.addAttribute("article", article);
            model.addAttribute("comments", commentService.getArticleComments(id));
            model.addAttribute("commentForm", new CommentForm());
            model.addAttribute("dates", articleService.getDates());

            return "articleComments";
        } else {
            return "noArticle";
        }
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteComment(@RequestParam(required = true) long commentId, @RequestParam(required = true) long articleId) {
        commentService.delete(commentId);

        return "redirect:/comments/" + articleId;
    }

    @RequestMapping(value = "/deleteArticle", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteArticle(@RequestParam(required = true) long id, Model m) {
        m.addAttribute("article", articleService.findById(id));
//        articleService.delete(id);
        articleService.delete(articleService.findById(id));
        m.addAttribute("dates", articleService.getDates());

        return "deletedArticle";
    }
}
