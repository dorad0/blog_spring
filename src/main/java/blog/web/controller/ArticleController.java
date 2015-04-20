/**
 * Created by user on 22.01.2015.
 */
package blog.web.controller;

import blog.entity.Article;
import blog.service.article.ArticleManager;
import blog.service.article.web.ArticleForm;
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
import java.util.GregorianCalendar;

@Controller
@RequestMapping("/article")
public class ArticleController {

    public static final int FIRST_PAGE = 1;
    public static final int FIRST_DAY = 1;

    @Autowired
    private ArticleManager service;

    @RequestMapping("/articles")
    public String getArticles(Model model) {
        getArticlesPage(FIRST_PAGE, model);
        return "article/articles";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getDefaultArticlePage(Model model) {
        return getArticles(model);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getDefaultPage(Model model) {
        return getArticles(model);
    }

    @RequestMapping(value = "/page/{pagenumber}", method = RequestMethod.GET)
    public String getArticlesPage(@PathVariable int pagenumber, Model model) {
        model.addAttribute("dates", service.getDates());
        model.addAttribute("page", service.getPagination().getPage(pagenumber));
        return "article/articles";
    }

    @RequestMapping(value = "archive/{year}/{month}", method = RequestMethod.GET)
    public String getArchiveArticles(Model model, @PathVariable(value = "year") int year, @PathVariable(value = "month") int month) {
        getArchiveArticlesPage(model, year, month, FIRST_PAGE);
        return "article/archive/archiveArticles";
    }

    @RequestMapping(value = "archive/{year}/{month}/page/{pagenumber}", method = RequestMethod.GET)
    public String getArchiveArticlesPage(Model model, @PathVariable(value = "year") int year, @PathVariable(value = "month") int month, @PathVariable int pagenumber) {
        model.addAttribute("page", service.getArchivePagination().getPage(pagenumber, year, month));
        model.addAttribute("date", new GregorianCalendar(year, month, FIRST_DAY));
        model.addAttribute("dates", service.getDates());
        return "article/archive/archiveArticles";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String createArticle(Model model) {
        model.addAttribute("articleForm", new ArticleForm());
        return "article/createForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String submitForm(@Valid ArticleForm articleForm, BindingResult result, Model entity) {
        if (result.hasErrors()) {
            return "article/createForm";
        }

        Article article = service.save(articleForm, (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        entity.addAttribute(article);
        return "redirect:/comments/" + article.getId();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteArticle(@RequestParam(required = true) long id, Model m) {
        m.addAttribute("article", service.findById(id));
        service.delete(id);
        m.addAttribute("dates", service.getDates());
        return "article/sucsessDelete";
    }
}
