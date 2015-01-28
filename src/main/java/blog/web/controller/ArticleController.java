package blog.web.controller;

import blog.service.ArticleServiceImpl;
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
    private ArticleServiceImpl service;

    @RequestMapping("/articles")
    public String getArticles(Model model) {

        model.addAttribute("articles", service.getArticles());

        return "article/articles";
    }
}
