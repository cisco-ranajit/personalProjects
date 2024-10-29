package com.medibill.main.exceptionhandler;

import java.time.LocalDateTime;
public class ErrorResponse {
    private int statusCode;
    private String message;
    private String cause;
    private LocalDateTime time;
    private String exceptionId;

    public ErrorResponse() {
    }

    public ErrorResponse(int statusCode, String message, String cause, LocalDateTime time, String exceptionId) {
        this.statusCode = statusCode;
        this.message = message;
        this.cause = cause;
        this.time = time;
        this.exceptionId = exceptionId;
    }


    // Getters and setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }
}
