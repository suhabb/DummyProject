package error;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static error.ErrorStatus.UNKNOWN_ERROR;

public class ErrorMessage {
    private ErrorStatus status;
    private List<String> errors;


    private ErrorMessage() {
    }

    public ErrorMessage(List<String> errors) {
        this(UNKNOWN_ERROR, errors);
    }

    public ErrorMessage(ErrorStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    public ErrorMessage(String error) {
        this(Collections.singletonList(error));
    }

    public ErrorMessage(ErrorStatus status, String error) {
        this(status, Collections.singletonList(error));
    }

    public ErrorMessage(String... errors) {
        this(Arrays.asList(errors));
    }

    public ErrorMessage(ErrorStatus status, String... errors) {
        this(status, Arrays.asList(errors));
    }

    public ErrorStatus getStatus() {
        return status;
    }

    public void setStatus(ErrorStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
