package blog.entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "publication_date", nullable = false)
    private Calendar publicationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "articles")
    private Set<Comment> comments;

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getCommentsCount() {

        return commentsCount;
    }

    @Formula("(SELECT COUNT(*) FROM comments WHERE comments.article_id = id)")
    private int commentsCount;

    public Article() {
        this.publicationDate = new GregorianCalendar();
    }

    public Article(String title, String text, Calendar publicationDate, User user) {
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (publicationDate != null ? !publicationDate.equals(article.publicationDate) : article.publicationDate != null)
            return false;
        if (text != null ? !text.equals(article.text) : article.text != null) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (user != null ? !user.equals(article.user) : article.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

}
