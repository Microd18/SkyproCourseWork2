package com.example.examquestions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundQuestionException extends RuntimeException {

    public NotFoundQuestionException() {
    }

    public NotFoundQuestionException(String message) {
        super(message);
    }

    public NotFoundQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundQuestionException(Throwable cause) {
        super(cause);
    }

    public NotFoundQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
