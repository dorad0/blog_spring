package blog.service;

import blog.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alex on 04.02.2015.
 */
@Service
public class ArticlePaginator {

    public static final int FIRST_PAGE = 0;
    public static final int PAGE_SIZE = 10;
//    public static final int PAGES = 0;

//    @Autowired
//    private ArticleDAO dao;

    private int pages;
    private int page;
    private int pageSize;
    private int articles;

    public ArticlePaginator() {
//        this.pages = PAGES;
        this.page = FIRST_PAGE;
        this.pageSize = PAGE_SIZE;
//        this.articles = dao.getArticleCount();
        this.articles = 1;
        this.pages = countPages(pageSize, articles);
    }

    public ArticlePaginator(int pageSize) {
        this.page = FIRST_PAGE;
        this.pageSize = pageSize;
//        this.articles = dao.getArticleCount();
        this.articles = 1;
        this.pages = countPages(pageSize, articles);
    }

    public ArticlePaginator(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
//        this.articles = (int) dao.getArticleCount();
        this.articles = 1;
        this.pages = countPages(pageSize, articles);
    }
//    @Transactional
//    public ArticlePage getPage(int page) {
////        if((page > pages) || (page <= 0 ))
////            throw new Exception();
//
//        ArticlePage articlePage = new ArticlePage(dao.getArticleGroup(page, pageSize));
//        return articlePage;
//    }
    @Transactional
    private int countPages(int pageSize, int items) {
        int pages;
//        if(pages == 0) throw new Exception();
        if(items <= pageSize) {
            pages = 1;
        }
        else if (items % pageSize == 0) {
            pages = items / pageSize;
        }
        else
            pages = items / pageSize + 1;
        return pages;
    }
}
