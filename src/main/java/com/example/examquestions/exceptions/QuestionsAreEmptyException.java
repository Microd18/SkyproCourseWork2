package com.example.examquestions.exceptions;

public class QuestionsAreEmptyException extends RuntimeException {

    public QuestionsAreEmptyException() {
    }

    public QuestionsAreEmptyException(String message) {
        super(message);
    }

    public QuestionsAreEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsAreEmptyException(Throwable cause) {
        super(cause);
    }

    public QuestionsAreEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
