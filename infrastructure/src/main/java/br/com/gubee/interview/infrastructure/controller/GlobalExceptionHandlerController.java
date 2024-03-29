package br.com.gubee.interview.infrastructure.controller;

import br.com.gubee.interview.core.exception.BadRequestException;
import br.com.gubee.interview.core.exception.InternalErrorException;
import br.com.gubee.interview.core.exception.ResourceNotFoundException;
import br.com.gubee.interview.infrastructure.dto.ErrorDetailsDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDTO> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                           WebRequest webRequest) {
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(getTime(), HttpStatus.NOT_FOUND.value(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetailsDTO> handleBadRequestException(BadRequestException exception,
                                                                     WebRequest webRequest) {
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(getTime(), HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalErrorException.class)
    public ResponseEntity<ErrorDetailsDTO> handleUnauthorizedExceptionException(InternalErrorException exception,
                                                                                WebRequest webRequest) {
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(getTime(), HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Long getTime() {
        return LocalDateTime.now().atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
    }
}
