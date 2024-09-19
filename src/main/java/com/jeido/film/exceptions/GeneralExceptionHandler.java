package com.jeido.film.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<Map<String, String>> errors = e.getBindingResult().getFieldErrors().stream().map(fieldError -> {
            Map<String, String> map = new HashMap<>();
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
            return map;
        }).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.toString());
    }
}
