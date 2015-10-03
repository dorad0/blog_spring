package blog.service.forms;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity(name = "user")
public class UserForm {

    @Size(min = 1, max = 30)
    private String name;

    @Size(min = 6, max = 30)
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
//    Dublicat ?
//    @Past
//    @Convert(converter = LocalDateConverter.class)
//    @Age(18)
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
