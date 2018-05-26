package constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePatternImpl implements ConstraintValidator<DatePattern, String> {

    private String pattern;

    @Override
    public void initialize(DatePattern constraintAnnotation) {

        //retrieves the parameter

        this.pattern = constraintAnnotation.pattern();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null) {
            return false;
        }

        try {
            DateFormat df = new SimpleDateFormat(pattern);
            Date dateObject = df.parse(value);
            if (!df.format(dateObject).equals(value)) {
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }

        return true;
    }
}
