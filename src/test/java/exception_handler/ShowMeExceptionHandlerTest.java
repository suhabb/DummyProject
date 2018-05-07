package exception_handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.TestMockWebApplicationContext;
import controller.CalculatorController;
import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestMockWebApplicationContext.class)
public class ShowMeExceptionHandlerTest {

    public static final String ERROR_TEXT = "errorText = ";
    private MockMvc mockMvc;

    @Mock
    private CalculatorController calculatorController;

    @InjectMocks
    private final CalculatorResource calculatorResource = new CalculatorResource();

    @Value("classpath:data/create_application.json")
    private Resource applicationResource;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void beforeTest() {
        mockMvc = standaloneSetup(calculatorResource)
                .setHandlerExceptionResolvers(createExceptionResolver())
                .build();
    }

    private ExceptionHandlerExceptionResolver createExceptionResolver() {
        ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
            @Override
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
                    HandlerMethod handlerMethod, Exception exception) {
                Method method = new ExceptionHandlerMethodResolver(ShowMeExceptionHandler.class)
                        .resolveMethod(exception);
                return new ServletInvocableHandlerMethod(new ShowMeExceptionHandler(), method);
            }
        };
        exceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }


    @Test
    public void handleShowMeBadRequestException() throws Exception {
        UserDefinedException showMeExceptionHandler = new UserDefinedException("400", ERROR_TEXT_GET.name(),
                new HttpClientErrorException(HttpStatus.BAD_REQUEST));
        when(calculatorResource.findById(anyLong())).thenThrow(userdefinedexceptionclass);
        MvcResult mvcResult = mockMvc.perform(get("/<api>/{appId}", anyLong()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[1]", StringContains.containsString("Resource does not Exist")))
                .andReturn();
        assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
        verify(facade, times(1)).findById(anyLong());
    }

    @Test
    public void handlehandleShowMeBadRequestUnauthorizedException() throws Exception {
        UserDefinedException pay4LaterException = new UserDefinedException("401", ERROR_TEXT_GET.name(),
                new HttpClientErrorException(HttpStatus.UNAUTHORIZED),
                );
        when(calculatorResource.findById(anyLong())).thenThrow(userdefinedexceptionclass);
        MvcResult mvcResult = mockMvc.perform(get("/<api>/{appId}", anyLong()))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.errors[1]", StringContains.containsString("Resource does not Exist")))
                .andReturn();
        assertEquals(HttpStatus.UNAUTHORIZED.value(), mvcResult.getResponse().getStatus());
        verify(calculatorResource, times(1)).findById(anyLong());
    }
}
