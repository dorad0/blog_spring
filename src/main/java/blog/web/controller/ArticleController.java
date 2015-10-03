package blog.web.controller;

import blog.entity.Article;
import blog.service.ArticleService;
import blog.service.forms.ArticleForm;
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
@RequestMapping("/article")
public class ArticleController {

    public static final int FIRST_PAGE = 1;
//    public static final int FIRST_DAY = 1;

    @Autowired
    private ArticleService articleService;


    @RequestMapping("/articles")
    public String getArticles(Model model) {
        getArticlesPage(FIRST_PAGE, model);
//        return "article/articles";
        return "articles";
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
        model.addAttribute("dates", articleService.getDates());
        model.addAttribute("page", articleService.getPagination().getPage(pagenumber));

        return "articles";
    }

    @RequestMapping(value = "archive/{year}/{month}", method = RequestMethod.GET)
    public String getArchiveArticles(Model model, @PathVariable(value = "year") int year,
                                     @PathVariable(value = "month") int month) {
        getArchiveArticlesPage(model, year, month, FIRST_PAGE);

        return "articleArchive";
    }

    @RequestMapping(value = "archive/{year}/{month}/page/{pagenumber}", method = RequestMethod.GET)
    public String getArchiveArticlesPage(Model model, @PathVariable(value = "year") int year,
                                         @PathVariable(value = "month") int month, @PathVariable int pagenumber) {
        model.addAttribute("page", articleService.getArchivePagination().getPage(pagenumber, year, month));
//        model.addAttribute("date", LocalDate.of(year, month, FIRST_DAY));
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("dates", articleService.getDates());

        return "articleArchive";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String createArticle(Model model) {
        model.addAttribute("articleForm", new ArticleForm());

        return "createArticleForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String submitForm(@Valid ArticleForm articleForm, BindingResult result, Model entity) {
        if (result.hasErrors()) {
            return "createArticleForm";
        }

        Article article = articleService.saveArticleFromForm(articleForm);

        entity.addAttribute(article);

        return "redirect:/comments/" + article.getId();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteArticle(@RequestParam(required = true) long id, Model m) {
        m.addAttribute("article", articleService.findById(id));
//        articleService.delete(id);
        articleService.delete(articleService.findById(id));
        m.addAttribute("dates", articleService.getDates());

        return "deletedArticle";
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
//    @Secured("ROLE_ADMIN")
//    public String deleteArticleREST(@PathVariable long id, Model m) {
//        m.addAttribute("article", articleService.findById(id));
//        articleService.delete(id);
//        m.addAttribute("dates", articleService.getDates());
//
//        return "deletedArticle";
//    }

}
