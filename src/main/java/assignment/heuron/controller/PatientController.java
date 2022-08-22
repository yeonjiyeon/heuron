package assignment.heuron.controller;


import assignment.heuron.domain.Patient;
import assignment.heuron.dto.request.PatientRequest;
import assignment.heuron.dto.response.PatientResponse;
import assignment.heuron.service.PatientService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PatientController {

  private final PatientService patientService;

  @PostMapping("/patient")
  public ResponseEntity<Long> savePatient(@RequestBody PatientRequest patientRequest)
      throws IOException {
    Long savePatientID = patientService.savePatient(patientRequest);

    return new ResponseEntity<>(savePatientID, HttpStatus.OK);
  }

  @GetMapping("/patient/{id}")
  public ResponseEntity<PatientResponse> readDetailPatient(@PathVariable Long id){
    PatientResponse patientResponse = patientService.readDetailPatient(id);
    return new ResponseEntity<>(patientResponse, HttpStatus.OK);
  }


}
