package blog.service.forms;

import blog.service.forms.validator.Age;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserForm {

    @Size(min = 1, max = 30)
    private String name;

    @Size(min = 6, max = 30)
    private String password;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
//    Dublicat ?
//    @Past
    @Age(18)
    private LocalDate birthDate;

    public UserForm() {
    }

    public UserForm(String name, String password, LocalDate birthDate) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
