package assignment.heuron.exception;

public class PatientNotFoundException extends RuntimeException {

  public PatientNotFoundException() {
    super();
  }

  public PatientNotFoundException(String message) {
    super(message);
  }
}
