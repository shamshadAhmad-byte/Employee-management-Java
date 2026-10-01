package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidExceptionResDto {
    private String message;
    private int statusCode;
    private String path;
    private Map<String, String> errors;
    private LocalDateTime timestamp;

    public ValidExceptionResDto(String message, int statusCode, String path, Map<String, String> errors, LocalDateTime timestamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.path = path;
        this.errors = errors;
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
    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
}
