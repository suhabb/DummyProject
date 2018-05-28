package constraint;

import data_transfer.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Slf4j
public class ElementSizeTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testListElementStringSize() {
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class, "oldAddress", Arrays.asList("ab", "ad"));
        violationSet.stream().forEach(violation -> {
            log.info("Violations:{}", violation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(0);
    }

    @Test
    public void testListElementStringInvalidSize() {
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class, "oldAddress", Arrays.asList("abcd1234", "1234567890"));
        violationSet.stream().forEach(violation -> {
            log.info("Violations:{}", violation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(1);
    }

    @Test
    public void testListElementStringInvalidSize2() {
        Set<ConstraintViolation<PersonDTO>> violationSet = validator
                .validateValue(PersonDTO.class, "oldAddress", Arrays.asList("ab", "1234567890"));
        violationSet.stream().forEach(personDTOConstraintViolation -> {
            log.info("Violations:{}", personDTOConstraintViolation.getMessage());
        });

        assertThat(violationSet.size()).isEqualTo(1);
    }

    @Test
    public void test() {

        ArrayList<String> al = new ArrayList<String>();
// Add elements to the array list.
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
// Use iterator to display contents of al.
        System.out.print("Original contents of al: ");
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();
// Modify objects being iterated.
        ListIterator<String> litr = al.listIterator();
        while (litr.hasNext()) {
            String element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Modified contents of al: ");
        itr = al.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();
// Now, display the list backwards.
        System.out.print("Modified list backwards: ");
        while (litr.hasPrevious()) {
            String element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

