package constraint;

import data_transfer.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Slf4j
public class ElementSizeTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testListElementStringSize(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"oldAddress", Arrays.asList("ab","ad"));
        violationSet.stream().forEach(violation -> {
            log.info("Violations:{}",violation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(0);
    }

    @Test
    public void testListElementStringInvalidSize(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"oldAddress", Arrays.asList("abcd1234","1234567890"));
        violationSet.stream().forEach(violation -> {
            log.info("Violations:{}",violation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(1);
    }

    @Test
    public void testListElementStringInvalidSize2(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"oldAddress", Arrays.asList("ab","1234567890"));
        violationSet.stream().forEach(personDTOConstraintViolation -> {
            log.info("Violations:{}",personDTOConstraintViolation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(1);
    }
}
