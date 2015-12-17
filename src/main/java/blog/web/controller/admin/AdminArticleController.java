package blog.web.controller.admin;

import blog.entity.Article;
import blog.entity.User;
import blog.service.ArticleService;
import blog.service.CommentService;
import blog.service.UserService;
import blog.service.forms.ArticleForm;
import blog.service.forms.CommentForm;
import org.hibernate.persister.entity.Loadable;
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
import java.util.List;

/**
 * Created by user_1 on 11/27/2015.
 */
@Controller
@RequestMapping(value = "/admin/article")
public class AdminArticleController {

    public static final int FIRST_PAGE = 1;

    @Autowired
    private ArticleService articleService;

//    @Autowired
//    private CommentService commentService;
//
//    @Autowired
//    private UserService userService;

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String getArticle(@PathVariable Long id, Model model) {
//        Article article = articleService.findById(id);
//        if (article != null) {
//            model.addAttribute("article", article);
//            model.addAttribute("comments", commentService.getArticleComments(id));
////            model.addAttribute("commentForm", new CommentForm());
////            model.addAttribute("dates", articleService.getDates());
//
//            return "adminArticleComments";
//        } else {
//            return "adminNoArticle";
//        }
//    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/titles", method = RequestMethod.GET)
    public String getArticlesTitles(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "adminArticleTitles";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping("/articles")
    public String getArticles(Model model) {
        getArticlesPage(FIRST_PAGE, model);
//        return "article/articles";
        return "adminArticles";
    }

////    @RequestMapping(method = RequestMethod.GET)
//    public String getDefaultArticlePage(Model model) {
//        return getArticles(model);
//    }



    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.GET)
    public String getDefaultArticlePage(Model model) {
//        return getArticles(model);
        return "adminArticleBasicFeatures";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String getDefaultPage(Model model) {
        return getArticles(model);
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/page/{pagenumber}", method = RequestMethod.GET)
    public String getArticlesPage(@PathVariable int pagenumber, Model model) {
        model.addAttribute("dates", articleService.getDates());
        model.addAttribute("page", articleService.getPagination().getPage(pagenumber));

        return "adminArticles";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/archive/{year}/{month}", method = RequestMethod.GET)
    public String getArchiveArticles(Model model, @PathVariable(value = "year") int year,
                                     @PathVariable(value = "month") int month) {
        getArchiveArticlesPage(model, year, month, FIRST_PAGE);

        return "adminArticleArchive";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/archive/{year}/{month}/page/{pagenumber}", method = RequestMethod.GET)
    public String getArchiveArticlesPage(Model model, @PathVariable(value = "year") int year,
                                         @PathVariable(value = "month") int month, @PathVariable int pagenumber) {
        model.addAttribute("page", articleService.getArchivePagination().getPage(pagenumber, year, month));
//        model.addAttribute("date", LocalDate.of(year, month, FIRST_DAY));
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("dates", articleService.getDates());

        return "adminArticleArchive";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String createArticle(Model model) {
        model.addAttribute("articleForm", new ArticleForm());

        return "createArticleForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @Secured(value = "ROLE_ADMIN")
    public String submitForm(@Valid ArticleForm articleForm, BindingResult result, Model entity) {
        if (result.hasErrors()) {
            return "createArticleForm";
        }

        Article article = articleService.saveArticleFromForm(articleForm);

        entity.addAttribute(article);

        return "redirect:/admin/comments/" + article.getId();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteArticle(@RequestParam(required = true) long id, Model m) {
        m.addAttribute("article", articleService.findById(id));
//        articleService.delete(id);
        articleService.delete(articleService.findById(id));
        m.addAttribute("dates", articleService.getDates());

        return "adminDeletedArticle";
    }
}

