package blog.service.util;

import blog.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Alex on 09.02.2015.
 */
@Service
@Transactional
public class ArticleArchives {

    @Autowired
    @Qualifier(value = "ArticleDAOImpl")
    private ArticleDAO dao;

    public List<Calendar> getDates() {
        return dao.getDates();
    }
}
