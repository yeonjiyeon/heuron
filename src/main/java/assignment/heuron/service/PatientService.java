package assignment.heuron.service;


import assignment.heuron.domain.Patient;
import assignment.heuron.dto.request.PatientRequest;
import assignment.heuron.dto.response.PatientResponse;
import java.io.IOException;


public interface PatientService {

  //저장 API
  public Long savePatient(PatientRequest patientRequest) throws IOException;


  //상세조회 API
  public PatientResponse readDetailPatient(Long patientId);


  //dto -> entity
  default public Patient dtoToEntity(PatientRequest patientRequest) {
    Patient patient = Patient.builder()
        .patientName(patientRequest.getPatientName())
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
        .build();

    return patientResponse;
  }
}
