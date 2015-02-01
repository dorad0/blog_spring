package blog.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "article")
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

    public Article(String title, String text, Date publicationDate, User user) {
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
        this.user = user;
    }

    //    @Temporal(value=TemporalType.TIME)
    @Column(name = "publicationDate", nullable = false)
    private Date publicationDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "article")
    private Set<Comment> comments;


    public Article() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
