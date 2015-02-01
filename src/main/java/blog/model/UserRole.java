package blog.model;

import blog.model.auth.Role;

import javax.persistence.*;

/**
 * Created by user on 07.01.2015.
 */
@Entity
@Table(name="user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private  long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "role", nullable = false)
    private String role;

//    @Column(name = "role", nullable = false)
//    private Role role;


    public UserRole() {
    }

    public UserRole(User user, String role) {
        this.user = user;
//        this.role = role.toString();
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", user=" + user +
                ", role='" + role + '\'' +
                '}';
    }
}
