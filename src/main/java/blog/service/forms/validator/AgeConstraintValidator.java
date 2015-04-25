package blog.service.forms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class AgeConstraintValidator implements ConstraintValidator<Age, Calendar> {

    private int annotationAge;

    @Override
    public void initialize(Age age) {
        this.annotationAge = age.value();
    }

    @Override
    public boolean isValid(Calendar target, ConstraintValidatorContext cxt) {
        if (target == null) {
            return true;
        }

        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        int targetYear = target.get(Calendar.YEAR);
        int age = currentYear - targetYear;
        return age >= annotationAge;
    }

}
