package blog.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 21.01.2015.
 */
public class AgeConstraintValidator  implements ConstraintValidator<Age, Date> {

    private int annotationAge;

    @Override
    public void initialize(Age age) {
        this.annotationAge = age.value();
    }

    @Override
    public boolean isValid(Date target, ConstraintValidatorContext cxt) {
        if(target == null) {
            return true;
        }
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        c.setTime(target);
        int fieldYear = c.get(Calendar.YEAR);
        int age = currentYear - fieldYear;

        return age >= annotationAge;
    }

}
