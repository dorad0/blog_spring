package blog.web.controller;


import blog.entity.Article;
import blog.service.article.ArticleManager;
import blog.service.article.web.ArticleForm;
import blog.service.pagination.article.ArticlePagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Created by user on 22.01.2015.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    public static final int FIRST_PAGE = 1;

    @Autowired
    private ArticleManager service;

    @Autowired
    private ArticlePagination pagination;

    @RequestMapping("/articles")
    public String getArticles(Model model) {
//        model.addAttribute("page", pagination.getFirstPage());
//        model.addAttribute("dates", service.getDates());
        showArticlesPage(FIRST_PAGE, model);
        return "article/articles";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showDefaultArticlePage(Model model) {
        return getArticles(model);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String showDefaultPage(Model model) {
        return getArticles(model);
    }

    @RequestMapping(value = "/page/{pagenumber}", method = RequestMethod.GET)
    public String showArticlesPage(@PathVariable int pagenumber, Model model) {
        model.addAttribute("dates", service.getDates());
        model.addAttribute("page", pagination.getPage(pagenumber));
        return "article/articles";
    }

    @RequestMapping(value="archive/")
    public String getArchiveArticles(Model model, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Calendar date) {
        model.addAttribute("dates", service.getDates());
        return "article/test";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String createArticle(Model model) {
        model.addAttribute("articleForm", new ArticleForm());
        return "article/createForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String submitForm(@Valid ArticleForm article, BindingResult result, Model entity) {
        if (result.hasErrors()) {
            return "article/createForm";
        }

        Article article1 = service.save(article, (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        entity.addAttribute(article1);
//        return "redirect:/article/" + article1.getId();
        return "article/articles";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String showArticleContent(@PathVariable long id, Model entity) {
        entity.addAttribute(service.findById(id));
        return "article/preview";
    }

    //исправить
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteArticle(@RequestParam(required = true) long id, Model m) {
        Article article = null;
        article = service.findById(id);
        if (article != null) {
            service.delete(article);
            m.addAttribute("article", article);
            return "article/sucsessDelete";
        } else {
            return "-----";
        }
    }
}
