package assignment.heuron.dto.request;

import assignment.heuron.domain.PatientGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientRequest {
  private String patientName;

  private int patientAge;

  private PatientGender patientGender;

  private boolean hasDisease;

}
