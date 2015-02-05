package blog.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    //    @Temporal(value = TemporalType.DATETIME)
    @Column(name = "registrationdate", nullable = false)
    private Calendar registrationDate;

    //    @Temporal(value = TemporalType.TIME)
    @Column(name = "birthdate", nullable = false)
    private Calendar birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Comment> comments;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<Article> articles;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private Set<UserRole> roles;

    public User() {
    }

    public User(boolean enabled, String name, String password, Calendar registrationDate, Calendar birthDate) {
        this.enabled = enabled;
        this.name = name;
        this.password = password;
        this.registrationDate = registrationDate;
        this.birthDate = birthDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", birthDate=" + birthDate +
                ", comments=" + comments +
                ", articles=" + articles +
                ", roles=" + roles +
                ", enabled=" + enabled +
                '}';
    }
}
