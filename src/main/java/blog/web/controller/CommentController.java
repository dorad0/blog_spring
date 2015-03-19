package blog.web.controller;

import blog.entity.Article;
import blog.service.article.ArticleManager;
import blog.service.comment.CommentManager;
import blog.service.comment.web.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

/**
 * Created by Alex on 18.02.2015.
 */
@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private ArticleManager articleService;

    @Autowired
    private CommentManager commentService;

    @RequestMapping("/{id}")
    public String getArticleWithComments(@PathVariable long id, Model model) {
        Article article = articleService.findById(id);
        if(article != null) {
            model.addAttribute("article", article);
            model.addAttribute("comments", commentService.getArticleComments(id));
            model.addAttribute("commentForm", new CommentForm());
            model.addAttribute("dates", articleService.getDates());
            return "comment/article";
        }
        else {
            return "comment/empty";
        }
    }

    @RequestMapping(value = "/add/{articleId}", method = RequestMethod.POST)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String addComment(@Valid CommentForm form, @PathVariable long articleId, BindingResult result) {
        if (result.hasErrors()) {
            return "comment/article";
        }
        commentService.addComment(articleId, form, ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return "redirect:/comments/" + articleId + "#end";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteComment(@RequestParam(required = true) long commentId, @RequestParam(required = true) long articleId) {
        commentService.deleteComment(commentId);
        return "redirect:/comments/" + articleId;
    }
}
