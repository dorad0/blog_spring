package blog.service.pagination.article;

import blog.dao.ArticleDAO;
import blog.entity.Article;
import blog.service.pagination.core.PaginationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Alex on 06.02.2015.
 */
@Service
@Transactional
public class ArticlePaginationImpl extends PaginationManager<Article, ArticleDAO> implements ArticlePagination {

    @Override
    @Autowired
    public void setDao(@Qualifier("ArticleDAOImpl") ArticleDAO dao) {
        super.setDao(dao);
    }
}
