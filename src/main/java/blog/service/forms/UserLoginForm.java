package blog.service.forms;

/**
 * Created by user_1 on 10/3/2015.
 */
public class UserLoginForm {
    private String name;
    private String password;

    public UserLoginForm() {
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
}
