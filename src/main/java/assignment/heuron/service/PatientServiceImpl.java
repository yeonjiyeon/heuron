package assignment.heuron.service;

import assignment.heuron.domain.Patient;
import assignment.heuron.dto.request.PatientRequest;
import assignment.heuron.repository.PatientRepository;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {


  private final PatientRepository patientRepository;
  private final FileService fileService;

  //저장 API
  public Long savePatient(PatientRequest patientRequest) throws IOException {
    Patient patient = patientRequest.toEntity();
    if (patientRequest.getPatientImage() != null) {
      String imageName = fileService.uploadFile(patientRequest.getPatientImage());
      patient.updateImageInfo(imageName);
    }
    patientRepository.save(patient);

    return patient.getId();
  }


}
