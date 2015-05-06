package blog.service.util;

import blog.entity.Article;
import blog.entity.User;
import blog.service.UserService;
import blog.service.forms.ArticleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Converter {

    @Autowired
    UserService userService;

    public Article convertArticleFormInArticle(ArticleForm articleForm) {
        Article article = new Article();
        article.setTitle(articleForm.getTitle());
        article.setText(articleForm.getText());
        User user = userService.findByName(articleForm.getUserName());
        article.setUser(user);
        article.setPublicationDate(LocalDateTime.now());

        return article;
    }
}
