package blog.service.form;

import blog.service.validator.Age;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Alex on 01.02.2015.
 */
public class UserForm {

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    @NotEmpty
    @Size(min = 6, max = 30)
    private String password;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    @Past
    @Age(18)
    private Date birthDate;

    public UserForm() {
    }

    public UserForm(String name, String password, Date birthDate) {
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
