package blog.web.controller;

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

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/{id}")
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

    @RequestMapping(value = "/add/{articleId}", method = RequestMethod.POST)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String addComment(@Valid CommentForm commentForm, @PathVariable long articleId, BindingResult result) {
        if (result.hasErrors()) {
            return "articleComments";
        }

        commentService.save(commentForm);

        return "redirect:/comments/" + articleId + "#end";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteComment(@RequestParam(required = true) long commentId, @RequestParam(required = true) long articleId) {
        commentService.delete(commentId);

        return "redirect:/comments/" + articleId;
    }

}
