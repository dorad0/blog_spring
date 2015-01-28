package blog.model;


import blog.validator.Age;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @NotEmpty
    @Size(min = 2, max = 30)
    @Column(name = "name", nullable = false, unique = true)
    private String name;

   /* @Min(6) @Max(30)*/
    @NotEmpty
    @Size(min = 6, max = 30)
    @Column(name = "password", nullable = false)
    private String password;

    //    @Temporal(value = TemporalType.DATETIME)
    @Column(name = "registrationdate", nullable = false)
    private Date registrationDate;

    //    @Temporal(value = TemporalType.TIME)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    @Past
    @Age(18)
    @Column(name = "bithdaydate", nullable = false)
    private Date birthdayDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Comment> comments;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Article> articles;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<UserRole> userRoles;

    public User() {
    }

    public User(String name, String password, Date registrationDate, Date birthdayDate, Set<Comment> comments, Set<Article> articles, Set<UserRole> userRoles) {
        this.name = name;
        this.password = password;
        this.registrationDate = registrationDate;
        this.birthdayDate = birthdayDate;
        this.comments = comments;
        this.articles = articles;
        this.userRoles = userRoles;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", birthdayDate=" + birthdayDate +
                ", comments=" + comments +
                ", articles=" + articles +
                ", roles=" + userRoles +
                '}';
    }
}
