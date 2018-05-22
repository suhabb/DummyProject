package mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Mapper {

    final Logger logger = LoggerFactory.getLogger(Mapper.class);

    @Autowired
    public ObjectMapper objectMapper;

    public <T> T readValue(Object object, Class<T> clazz) {
        try {
            return objectMapper.readValue(writeValueAsString(object), clazz);
        } catch (IOException exception) {
            logger.debug("Json exception read value method", exception);
            throw new RuntimeException(exception);
        }
    }

    public String writeValueAsString(Object clazz) {
        try {
            return objectMapper.writeValueAsString(clazz);
        } catch (JsonProcessingException exception) {
            logger.debug("Json exception write value as string method", exception);
            throw new RuntimeException(exception);
        }
    }

}
