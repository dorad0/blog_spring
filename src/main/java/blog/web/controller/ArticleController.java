package blog.web.controller;

import blog.model.Article;
import blog.service.ArticleService;
import blog.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by user on 22.01.2015.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @RequestMapping("/articles")
    public String getArticles(Model model) {

        model.addAttribute("articles", service.getArticles());
        return "article/articles";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createArticle(Model model) {

        model.addAttribute(new Article());
        return "article/createForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@Valid Article article, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "article/creatForm";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        service.saveArticle(article, user.getUsername());
        model.addAttribute(article);
        return "redirect:/article/" + article.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showArticleContent(@PathVariable long id, Model model) {

        model.addAttribute(service.getArticleById(id));
        return "article/preview";
    }
}
