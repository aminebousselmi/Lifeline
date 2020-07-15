package com.lifeline.api.homeconfig.utility.exceptions;

import com.lifeline.api.homeconfig.utility.exceptions.custom.HomeConfigNotFoundException;
import com.lifeline.api.homeconfig.utility.exceptions.custom.InvalidUUIDSignatureException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HomeConfigExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        ValidationListError errorMessages = new ValidationListError(new Date(), validationList);

        return new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidUUIDSignatureException.class})
    public ResponseEntity<Object> handleInvalidUUIDException(InvalidUUIDSignatureException exception, WebRequest request) {

        String errorMessageDescription = exception.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HomeConfigNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(HomeConfigNotFoundException exception, WebRequest request) {

        String errorMessageDescription = exception.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException exception, WebRequest request){

        String errorMessageDescription = exception.getLocalizedMessage();
        if(errorMessageDescription == null) errorMessageDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest request){

        String errorMessageDescription = exception.getLocalizedMessage();
        if(errorMessageDescription == null) errorMessageDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
