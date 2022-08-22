package assignment.heuron.service;

import assignment.heuron.domain.Patient;
import assignment.heuron.dto.request.PatientRequest;
import java.io.IOException;


public interface PatientService {

  //저장 API
  public Long savePatient(PatientRequest patientRequest) throws IOException;
}
