package com.librarypackage.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);




//    public Map<String, String> handleDataAccessException (EmptyResultDataAccessException e) {
//    	Map<String, String> errorMap = new HashMap<>();
//    	e.
//
//    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> EmptyResultDataAccessException(EmptyResultDataAccessException e) {
        log.error("EmptyResultDataAccessException caught: {}", e.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Error while accessing data");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> DataAccessExceptionHandler (DataAccessException e){
    	log.error("Data exception error caught: {}" , e.getMessage());
    	ErrorResponse errorResponse = new ErrorResponse("Error with database");
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


}