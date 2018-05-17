package com.seankang.web.exception;

public class BidNotFoundException extends RuntimeException {

    public BidNotFoundException() {
        super();
    }

    public BidNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BidNotFoundException(final String message) {
        super(message);
    }

    public BidNotFoundException(final Throwable cause) {
        super(cause);
    }
}