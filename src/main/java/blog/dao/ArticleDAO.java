package blog.dao;


import blog.entity.Article;
import blog.entity.Comment;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 19.12.2014.
 */
public interface ArticleDAO extends GenericDAO<Article> {

    public Set<Comment> getComments(long id);

    public List<Calendar> getDates();
}

