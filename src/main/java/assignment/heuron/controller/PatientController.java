package assignment.heuron.controller;


import assignment.heuron.domain.Patient;
import assignment.heuron.dto.request.PatientRequest;
import assignment.heuron.dto.response.PatientResponse;
import assignment.heuron.service.PatientService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class PatientController {

  private final PatientService patientService;

  @PostMapping(value = "/patient", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<Long> savePatient(@RequestPart PatientRequest patientRequest, @RequestPart(required = false)
      MultipartFile imageFile)
      throws IOException {
    Long savePatientID;

    if(imageFile == null) savePatientID = patientService.savePatient(patientRequest, null);

    savePatientID = patientService.savePatient(patientRequest, imageFile);


    return new ResponseEntity<>(savePatientID, HttpStatus.OK);
  }

  @GetMapping("/patient/{id}")
  public ResponseEntity<PatientResponse> readDetailPatient(@PathVariable Long id) {
    PatientResponse patientResponse = patientService.readDetailPatient(id);
    return new ResponseEntity<>(patientResponse, HttpStatus.OK);
  }


}
