package blog.service.article;

import blog.dao.ArticleDAO;
import blog.entity.Article;
import blog.entity.Comment;
import blog.service.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 05.02.2015.
 */
@Service
@Transactional
public class ArticleManagerImpl extends GenericManagerImpl<Article, ArticleDAO> implements ArticleManager {

    @Override
    @Autowired
    protected void setDao(@Qualifier("ArticleDAOImpl") ArticleDAO dao) {
        super.setDao(dao);
    }

    @Override
    public Set<Comment> getComments(long id) {
        return dao.getComments(id);
    }

    @Override
    public List<Calendar> getDates() {
        return dao.getDates();
    }
}
