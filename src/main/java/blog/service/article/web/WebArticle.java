package blog.service.article.web;

import blog.entity.Article;
import blog.entity.Comment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Alex on 03.02.2015.
 */
public class WebArticle {
    private Article article;

    public WebArticle() {

    }

    public WebArticle(Article article) {
        this.article = article;
    }

    public String getDate() {
        Calendar date = article.getPublicationDate();
        return new SimpleDateFormat("MMMMM d,  yyyy", Locale.ENGLISH).format(date.getTime());
    }

    public String getTitle() {
        return article.getTitle();
    }

    public String getText() {
        return article.getText();
    }

    public String getAuthor() {
        return article.getUser().getName();
    }

    public Set<Comment> getComments() {
        return article.getComments();
    }
}
