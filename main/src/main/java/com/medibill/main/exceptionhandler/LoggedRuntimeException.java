package com.medibill.main.exceptionhandler;

public class LoggedRuntimeException extends RuntimeException {
    private int statusCode;

    public LoggedRuntimeException(String message) {
        super(message);
    }

    public LoggedRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoggedRuntimeException(Throwable cause) {
        super(cause);
    }

    public int getStatusCode() {
        return statusCode;
    }

}
