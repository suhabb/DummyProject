package constraint;

import data_transfer.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Slf4j
public class DatePatternTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


    @Test
    public void testDatePattern(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"date","2017-12-01");

        assertThat(violationSet.size()).isEqualTo(0);
    }

    @Test
    public void testDatePattern2(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"date","2020-12-01");

        assertThat(violationSet.size()).isEqualTo(0);
    }


    @Test
    public void testDatePatternWrongString(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"date","2017-02-30asas");
        violationSet.stream().forEach(personDTOConstraintViolation -> {
            log.info("Violations:{}",personDTOConstraintViolation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(1);
    }

    @Test
    public void testDatePatternWrongFormat(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"date","02-01-2017");
        violationSet.stream().forEach(personDTOConstraintViolation -> {
            log.info("Violations:{}",personDTOConstraintViolation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(1);
    }

    @Test
    public void testDatePatternWrongFormat_YYY(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"date","02/01/2017");
        violationSet.stream().forEach(personDTOConstraintViolation -> {
            log.info("Violations:{}",personDTOConstraintViolation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(1);
    }

    @Test
    public void testDatePatternWrongInvalidDate(){
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class,"date","2017-02-30");
        violationSet.stream().forEach(personDTOConstraintViolation -> {
            log.info("Violations:{}",personDTOConstraintViolation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(1);
    }
}
