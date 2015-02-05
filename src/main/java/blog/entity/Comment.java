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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
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

}
