package blog.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by user on 21.01.2015.
 */
@Documented
@Constraint(validatedBy = AgeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {

    int value();

    String message() default "Must be at least 18 years old";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}