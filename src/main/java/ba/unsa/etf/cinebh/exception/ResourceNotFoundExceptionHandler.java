package ba.unsa.etf.cinebh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ResourceNotFoundExceptionHandler {

  @ExceptionHandler(value = {ba.unsa.etf.cinebh.exception.ResourceNotFoundException.class})
  public ResponseEntity<Object> handleResourceNotFoundException(ba.unsa.etf.cinebh.exception.ResourceNotFoundException e){
    ba.unsa.etf.cinebh.exception.Exception exception = new ba.unsa.etf.cinebh.exception.Exception(
        e.getMessage(),
        HttpStatus.BAD_REQUEST,
        ZonedDateTime.now(ZoneId.of("Z"))
    );
    return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
  }
}

