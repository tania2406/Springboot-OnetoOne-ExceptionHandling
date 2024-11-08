package com.springbootproject.Springboot_OnetoOne_sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchConsumerExistsException.class)
    ResponseEntity<?> handleNoSuchConsumerExistsException(NoSuchConsumerExistsException ee)
    {
        String message =ee.getMessage();
        return new ResponseEntity<>(message ,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ConsumerAlreadyExistsException.class)
    ResponseEntity<?> handleConsumerAlreadyExistsException(ConsumerAlreadyExistsException ee)
    {
        String message =ee.getMessage();
        return new ResponseEntity<>(message ,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

