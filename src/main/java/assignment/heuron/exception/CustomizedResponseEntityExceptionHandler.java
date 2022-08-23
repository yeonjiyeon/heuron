package assignment.heuron.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleServiceException(CustomException exception) {
    return ResponseEntity
        .status(exception.getHttpStatus())
        .body(new ErrorResponse(exception.getMessage()));
  }
}
