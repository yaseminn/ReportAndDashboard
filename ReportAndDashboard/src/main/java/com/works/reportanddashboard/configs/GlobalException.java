package com.works.reportanddashboard.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();
        return new ResponseEntity<>(parseError(errors), HttpStatus.BAD_REQUEST);
    }

    private List parseError(List<FieldError> fieldErrors){
        List errors = new ArrayList();
        for(FieldError error : fieldErrors){
            Map<String, Object> map = new HashMap<>();
            map.put("field", error.getField());
            map.put("message", error.getDefaultMessage());
            map.put("rejectedValue", error.getRejectedValue());
            errors.add(map);
        }
        return errors;
    }
}
