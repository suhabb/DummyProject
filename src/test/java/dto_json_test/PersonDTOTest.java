package dto_json_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import data_transfer.PersonDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
public class PersonDTOTest {

    private ObjectMapper mapper;

    @Value("${classpath:json_docs/person_json.json}")
    private InputStream person;

    @Before
    public void setUp() throws Exception {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    public void testPersonDTO() throws IOException {
        PersonDTO personDTO = mapper.readValue(person, PersonDTO.class);
        Assert.assertEquals("abc",personDTO.getCompany());

    }

}
