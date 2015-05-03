package blog.service.forms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeConstraintValidator implements ConstraintValidator<Age, LocalDate> {

    private int annotationAge;

    @Override
    public void initialize(Age age) {
        this.annotationAge = age.value();
    }

    @Override
    public boolean isValid(LocalDate target, ConstraintValidatorContext cxt) {
        if (target == null) {
            return true;
        }

        LocalDate c = LocalDate.now();
        int currentYear = c.getYear();
        int targetYear = target.getYear();
        int age = currentYear - targetYear;
        return age >= annotationAge;
    }
}
