package assignment.heuron.service;

import assignment.heuron.domain.Patient;
import assignment.heuron.dto.request.PatientRequest;
import assignment.heuron.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService{


  private final PatientRepository patientRepository;

  //저장 API
  public Long savePatient(PatientRequest patientRequest) {
    Patient patient = patientRequest.toEntity();

    patientRepository.save(patient);

    return patient.getId();
  }


}
