package assignment.heuron.exception;

import org.springframework.http.HttpStatus;

public class NotLevelTwoException extends RuntimeException {
  public NotLevelTwoException(){
    super();
  }

  public NotLevelTwoException(String message){
    super(message);
  }

  public NotLevelTwoException(HttpStatus httpStatus,String message){
    super(message);
  }
}
