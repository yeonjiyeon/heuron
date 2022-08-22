package assignment.heuron.service;

import assignment.heuron.domain.Patient;
import assignment.heuron.domain.SaveLevel;
import assignment.heuron.dto.request.PatientRequest;
import assignment.heuron.dto.response.PatientResponse;
import assignment.heuron.exception.PatientNotFoundException;
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
  @Override
  public Long savePatient(PatientRequest patientRequest) throws IOException {
    Patient patient = dtoToEntity(patientRequest);
    if (patientRequest.getPatientImage() != null) {
      String imageName = fileService.uploadFile(patientRequest.getPatientImage());
      patient.updateImageInfo(imageName);
      patient.updateSaveLevel(SaveLevel.LEVEL2);
    }

    patientRepository.save(patient);

    return patient.getId();
  }

  //저장 단계 검사
  /*public void validationLevel(Patient patient){
    if(!patient.isLevelTwo(patient.getSaveLevel())){
      //true가 아니라면 에러 발생
    }
  }*/


  //상세조회 API
  @Override
  public PatientResponse readDetailPatient(Long patientId) {
    Patient patient = patientRepository.findById(patientId).orElse(null);
    //validationLevel(patient);
    PatientResponse patientResponse = entityToDTO(patient);
    return patientResponse;
  }



}
