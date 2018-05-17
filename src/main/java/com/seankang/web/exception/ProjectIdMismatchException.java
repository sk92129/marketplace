package com.seankang.web.exception;

public class ProjectIdMismatchException extends RuntimeException {

    public ProjectIdMismatchException() {
        super();
    }

    public ProjectIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProjectIdMismatchException(final String message) {
        super(message);
    }

    public ProjectIdMismatchException(final Throwable cause) {
        super(cause);
    }
}