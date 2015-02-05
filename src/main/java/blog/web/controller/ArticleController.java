package blog.web.controller;

import blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
//        pagination = new ArticlePagination(1, 10);
//        entity.addAttribute("articles", service.getArticlesByPage(0L, 10L));
//        entity.addAttribute("page", service.getArticlePage(10));
//        return "article/articles";
        model.addAttribute("article", service.getArticleById(2));
        return "article/test";
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
