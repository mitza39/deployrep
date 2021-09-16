package luxoft.example.springboot.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp = new Date();
    private String message;
    private String details;

    public ExceptionResponse(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
