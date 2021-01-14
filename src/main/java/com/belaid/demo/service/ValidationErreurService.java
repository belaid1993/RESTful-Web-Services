package com.belaid.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationErreurService {

    public ResponseEntity<?> validate(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> erreurMap = new HashMap<String, String>();
            for (FieldError error : result.getFieldErrors()) {
                erreurMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(erreurMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
