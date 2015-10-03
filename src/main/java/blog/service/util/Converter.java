package blog.service.util;

import blog.entity.Article;
import blog.entity.Comment;
import blog.entity.User;
import blog.service.UserService;
import blog.service.forms.ArticleForm;
import blog.service.forms.CommentForm;
import blog.service.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Converter {

    @Autowired
    UserService userService;

    public Article convertArticleFormToArticle(ArticleForm articleForm) {
        Article article = new Article();
        article.setTitle(articleForm.getTitle());
        article.setText(articleForm.getText());
        User user = userService.findByName(articleForm.getUserName());
        article.setUser(user);

        return article;
    }

    public User convertUserFormToUser(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setBirthDate(userForm.getBirthDate());
        user.setPassword(userForm.getPassword());

        return user;
    }

    public Comment convertCommentFormToComment(CommentForm commentForm) {
        Comment comment = new Comment();
        comment.setText(commentForm.getText());

        User user = userService.findByName(commentForm.getUserName());

//        User user = new User();
//        user.setName(commentForm.getUserName());
        comment.setUser(user);

        Article article = new Article();
        article.setId(commentForm.getArticleId());

        comment.setArticle(article);

        return comment;
    }
}
