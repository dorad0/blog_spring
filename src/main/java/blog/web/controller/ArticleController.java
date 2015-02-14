package blog.web.controller;

import blog.entity.Article;
import blog.service.article.ArticleManager;
import blog.service.pagination.article.ArticlePagination;
import blog.service.util.ArticleArchives;
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
 * Created by user on 22.01.2015.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleManager service;

    @Autowired
    private ArticleArchives archives;

    @Autowired
    private ArticlePagination pagination;

    @RequestMapping("/articles")
    public String getArticles(Model model) {
        model.addAttribute("page", pagination.getPage(1));
        model.addAttribute("dates", archives.getDates());
        return "article/articles";
    }

    @RequestMapping(value = "articles/{pagenumber}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable int pagenumber, Model model) {
        model.addAttribute("dates", archives.getDates());
        model.addAttribute("page", pagination.getPage(pagenumber));
        return "article/articles";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @Secured("ROLE_USER")
    public String createArticle(Model entity) {

        entity.addAttribute(new Article());
        return "article/createForm";
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public String submitForm(@Valid Article article, BindingResult result, Model entity) {

        if (result.hasErrors()) {
            return "article/creatForm";
        }

//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        service.save(article, (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        entity.addAttribute(article);
        return "redirect:/article/" + article.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String showArticleContent(@PathVariable long id, Model entity) {

        entity.addAttribute(service.findById(id));
        return "article/preview";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteArticle(@RequestParam(required = true) long id, Model m) {
        Article article = null;
        article = service.findById(id);
        if (article != null) {
            service.delete(article);
            m.addAttribute("article", article);
            return "article/sucsessDelete";
        }
        else
        {
            return "-----";
        }
    }
}
