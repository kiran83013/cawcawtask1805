package com.travel.travtronics.globalexceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.travel.travtronics.exceptions.ConflictException;
import com.travel.travtronics.response.APIResponse;

@ControllerAdvice
public class GlobalExceptionHandeler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(final HttpServletRequest request, final Exception exception) {
        final String msg = String.format("Exception %s", exception.getMessage());
        return buildResponseEntity(new APIResponse(HttpStatus.BAD_REQUEST.value(), msg, Collections.emptyList()), request, exception);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "";
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) ex.getCause();
            for (JsonMappingException.Reference reference : invalidFormatException.getPath()) {
                message = String.format("Input field %s with value %s is not valid format", reference.getFieldName(), invalidFormatException.getValue());
            }
            logger.error(message);
            return handleExceptionInternal(ex, new APIResponse(HttpStatus.BAD_REQUEST.value(), message, new ArrayList<>()), headers, HttpStatus.OK, request);
        }
        message = "Bad request, check request Body formatting.";
        return handleExceptionInternal(ex, new APIResponse(HttpStatus.BAD_REQUEST.value(), message, new ArrayList<>()), headers, HttpStatus.OK, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.add(fieldError.getField() + "" + fieldError.getDefaultMessage());
        });
        return handleExceptionInternal(ex, new APIResponse(HttpStatus.BAD_REQUEST.value(), "Validation error", errors), headers, HttpStatus.OK, request);
    }

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<Object> handleJavaxValidationError(final HttpServletRequest request, final Exception exception) {
        final String msg = "Validation error";
        logger.error(exception.getMessage());
        return buildResponseEntity(new APIResponse(HttpStatus.BAD_REQUEST.value(), msg, Arrays.asList(exception.getMessage().split(","))), request, exception);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<Object> handleMethodArgumentTypeMismatchException(final HttpServletRequest request, final Exception exception) {
        if (exception.getCause() instanceof NumberFormatException) {
            String message = String.format("Expecting numeric value %s", exception.getCause().getMessage());
            return buildResponseEntity(new APIResponse(HttpStatus.BAD_REQUEST.value(), message, Collections.emptyList()), request, exception);
        }
        return buildResponseEntity(new APIResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), Collections.emptyList()), request, exception);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Object> handleConflictException(final HttpServletRequest request, final Exception exception){
        return buildResponseEntity(new APIResponse(HttpStatus.CONFLICT.value(), exception.getMessage(), Collections.emptyList()), request,exception);
    }

    private ResponseEntity<Object> buildResponseEntity(final APIResponse response, final HttpServletRequest request, final Exception exception) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}



