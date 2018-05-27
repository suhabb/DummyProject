package constraints;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ElementSizeImpl implements ConstraintValidator<ElementSize, List<String>> {

    private int min;
    private int max;

    @Override
    public void initialize(ElementSize constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();

    }

    @Override
    public boolean isValid(List<String> list, ConstraintValidatorContext constraintValidatorContext) {

        if (Objects.isNull(list)) {
            return false;
        }
        boolean isValid = list.stream()
                .allMatch(value -> value.length() > min && value.length() <= max);
        return isValid;
    }
}
