package blog.service.pagination.article;

import blog.entity.Article;
import blog.service.data.WebArticle;

import java.util.List;

/**
 * Created by Alex on 04.02.2015.
 */
public class ArticlePage {

    private List<WebArticle> articles;

    public ArticlePage(List<Article> articles) {
        for(Article a : articles) {
            this.articles.add(new WebArticle(a));
        }
    }

    public List<WebArticle> getArticles() {

        return articles;
    }

    public void setArticles(List<WebArticle> articles) {
        this.articles = articles;
    }
}
