package com.example.examquestions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectNumberOfQuestionsException extends RuntimeException{

    public IncorrectNumberOfQuestionsException() {
    }

    public IncorrectNumberOfQuestionsException(String message) {
        super(message);
    }

    public IncorrectNumberOfQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectNumberOfQuestionsException(Throwable cause) {
        super(cause);
    }

    public IncorrectNumberOfQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
