package assignment.heuron.dto.response;

import assignment.heuron.domain.PatientGender;
import assignment.heuron.domain.SaveLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PatientResponse {

  private String patientName;

  private int patientAge;

  private PatientGender patientGender;

  private boolean hasDisease;

  private SaveLevel saveLevel;

  private String imagePath;





}
