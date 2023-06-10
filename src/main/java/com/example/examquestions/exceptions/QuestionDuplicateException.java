package com.example.examquestions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionDuplicateException extends RuntimeException {

    public QuestionDuplicateException() {
    }

    public QuestionDuplicateException(String message) {
        super(message);
    }

    public QuestionDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionDuplicateException(Throwable cause) {
        super(cause);
    }

    public QuestionDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
