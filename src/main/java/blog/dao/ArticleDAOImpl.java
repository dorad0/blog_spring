package blog.dao;


import blog.model.Article;
import blog.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 15.12.2014.
 */
/*Spring takes care about transactions*/
@Repository
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void addArticle(Article article) {
        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
            session = sessionFactory.getCurrentSession();
            session.save(article);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("Exception occured. " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
    }

    @Override
    public void deleteArticle(Article article) {
        Session session = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
            session = sessionFactory.getCurrentSession();
            session.delete(article);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("Exception occured. " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//       }
    }

    @Override
    public Set<Comment> getComments(long id) {
        Session session = null;
        Set<Comment> comments = null;
        Article article = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
            session = sessionFactory.getCurrentSession();
            article = (Article)session.load(Article.class, id);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("Exception occured. " + e.getMessage());
//            e.printStackTrace();
//        } /*finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }*/
        return article.getComments();
    }

    @Override
    public Article getArticleById(long id) {
        Session session = null;
        Article article = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
            session = sessionFactory.getCurrentSession();
            article = (Article) session.get(Article.class, id);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("Exception occured. " + e.getMessage());
//            e.printStackTrace();
//        } /*finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }*/
        return article;
    }

    @Override
    public List<Article> getAllArticles() {
        Session session = null;
        List<Article> articles = null;
//        try {
////            session = HibernateUtil.getSessionFactory().openSession();
////            session.beginTransaction();
            session = sessionFactory.getCurrentSession();
            articles =  session.createSQLQuery("SELECT * from article").addEntity(Article.class).list();
////            session.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("Exception occured. " + e.getMessage());
//            e.printStackTrace();
//        } /*finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }*/
        return articles;
    }
}
