package com.example.demo.dto;

import java.time.LocalDateTime;

public class ExceptionResDto {
    private String message;
    private int statusCode;
    private String path;
    private String error;
    private LocalDateTime timestamp;

    public ExceptionResDto(String message, int statusCode, String path, String error, LocalDateTime timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.path = path;
        this.error = error;
        this.timestamp = timestamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
}
