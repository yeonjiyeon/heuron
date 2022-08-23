package assignment.heuron.service;


import assignment.heuron.domain.Patient;
import assignment.heuron.dto.request.PatientRequest;
import assignment.heuron.dto.response.PatientResponse;
import org.springframework.web.multipart.MultipartFile;


public interface PatientService {

  //저장 API
  public Long savePatient(PatientRequest patientRequest, MultipartFile imageFile) throws Exception;


  //상세조회 API
  public PatientResponse readDetailPatient(Long patientId);


  //이미지 조회 API
  public byte[] readImage(String imagePath) throws Exception;


  //삭제 API
  public void deletePatient(Long patientId);


  //dto -> entity
  default public Patient dtoToEntity(PatientRequest patientRequest) {
    Patient patient = Patient.builder()
        .patientName(patientRequest.getPatientName())
        .patientAge(patientRequest.getPatientAge())
        .patientGender(patientRequest.getPatientGender())
        .hasDisease(patientRequest.isHasDisease())
        .build();

    return patient;
  }

  //entity -> dto
  default PatientResponse entityToDTO(Patient patient) {
    PatientResponse patientResponse = PatientResponse.builder()
        .patientName(patient.getPatientName())
        .patientAge(patient.getPatientAge())
        .patientGender(patient.getPatientGender()).hasDisease(patient.isHasDisease())
        .saveLevel(patient.getSaveLevel())
        .imagePath(patient.getImagePath())
        .build();

    return patientResponse;
  }
}
