package blog.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by user on 13.12.2014.
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "text", nullable = false)
    private String text;

    //    @Temporal(value = TemporalType.TIME)
    @Column(name = "publicationDate", nullable = false)
    private Calendar publicationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    public Comment() {
    }

    public Comment(String text, Calendar publicationDate, User user, Article article) {
        this.text = text;
        this.publicationDate = publicationDate;
        this.user = user;
        this.article = article;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (article != null ? !article.equals(comment.article) : comment.article != null) return false;
        if (publicationDate != null ? !publicationDate.equals(comment.publicationDate) : comment.publicationDate != null)
            return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        if (user != null ? !user.equals(comment.user) : comment.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        return result;
    }
}
