package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ExceptionResDto;
import com.example.demo.dto.ValidExceptionResDto;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice 
public class GlobleExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResDto> handleEmployeeNotFoundException(NotFoundException ex, HttpServletRequest request){
        ExceptionResDto exceptionResDto =new ExceptionResDto(
            ex.getMessage(),
            404,
            request.getRequestURI(),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            LocalDateTime.now()
        );
        
        return ResponseEntity.status(404).body(exceptionResDto);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ExceptionResDto> handleDuplicateException(DuplicateException ex, HttpServletRequest request){
        ExceptionResDto exceptionResDto =new ExceptionResDto(
            ex.getMessage(),
            409,
            request.getRequestURI(),
            HttpStatus.CONFLICT.getReasonPhrase(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(409).body(exceptionResDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidExceptionResDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        Map<String,String> errors =new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errors.put(error.getField(), error.getDefaultMessage());
        });
        ValidExceptionResDto exceptionResDto =new ValidExceptionResDto(
            "Validation failed",
            400,
            request.getRequestURI(),
            errors,
            LocalDateTime.now()
        );
        return ResponseEntity.status(400).body(exceptionResDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResDto> handleException(Exception e, HttpServletRequest request){
        ExceptionResDto exceptionResDto =new ExceptionResDto(
            e.getMessage(),
            500,
            request.getRequestURI(),
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(500).body(exceptionResDto);
    }
    
}
