package blog.web.controller;

import blog.dao.ArticleDAO;
import blog.dao.ArticleDAOImpl;
import blog.entity.Article;
import blog.service.article.ArticleManager;
import blog.service.pagination.article.ArticlePagination;
import blog.service.pagination.core.Pagination;
import blog.service.pagination.core.PaginationManager;
import blog.service.util.ArticleArchives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.List;

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
    @Secured("ROLE_USER")
    public String getArticles(Model model) {
//        pagination = new ArticlePagination(1, 10);
//        entity.addAttribute("articles", service.getArticlesByPage(0L, 10L));
//        entity.addAttribute("page", service.getArticlePage(10));
//        return "article/articles";
        model.addAttribute("page", pagination.getPage(0, 2));
        List<Calendar> list = archives.getDates();
        System.out.println(
                list
        );
        model.addAttribute("dates", list);
        return "article/articles";
    }

    @RequestMapping(value = "articles/{pagenumber}", method = RequestMethod.GET)
    public String showUserProfile(@PathVariable int pagenumber, Model model) {
        model.addAttribute("dates", archives.getDates());
        model.addAttribute("page", pagination.getPage(pagenumber, 2));
        return "article/articles";
    }

//    @RequestMapping(value = "/form", method = RequestMethod.GET)
////    @Secured("hasAuthority('ROLE_USER')")
//    public String createArticle(Model entity) {
//
//        entity.addAttribute(new Article());
//        return "article/createForm";
//    }


//    @RequestMapping(value = "/form", method = RequestMethod.POST)
////    @Secured("hasAuthority('ROLE_ADMIN')")
//    public String submitForm(@Valid Article article, BindingResult result, Model entity) {
//
//        if(result.hasErrors()) {
//            return "article/creatForm";
//        }
//
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        service.saveArticle(article, user.getUsername());
//        entity.addAttribute(article);
//        return "redirect:/article/" + article.getId();
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String showArticleContent(@PathVariable long id, Model entity) {
//
//        entity.addAttribute(service.getArticleById(id));
//        return "article/preview";
//    }
}
