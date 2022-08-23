package assignment.heuron.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler {
  /*@org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
  protected ResponseEntity<ErrorResponse> CustomizedResponseEntityExceptionHandler(CustomException e){
    //return ErrorResponse.

  }*/
}
