package assignment.heuron.dto.request;

import assignment.heuron.domain.Patient;
import assignment.heuron.domain.PatientGender;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientRequest {

  private String patientName;

  private int patientAge;

  private PatientGender patientGender;

  private boolean hasDisease;

  private MultipartFile patientImage;

  public Patient toEntity() {
    Patient patient = Patient.builder()
        .patientName(patientName)
        .patientGender(patientGender)
        .hasDisease(hasDisease)
        .build();

    return patient;
  }

}
