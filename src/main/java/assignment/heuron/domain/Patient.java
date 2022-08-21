package assignment.heuron.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
public class Patient {

  @Id
  @GeneratedValue
  private Long id;

  private String patientName;

  private int patientAge;

  private PatientGender patientGender;

  private boolean hasDisease;

  private String imageName;

  private String imagePath;

  @Builder
  public Patient(String patientName, int patientAge, PatientGender patientGender,
      boolean hasDisease) {
    this.patientName = patientName;
    this.patientAge = patientAge;
    this.patientGender = patientGender;
    this.hasDisease = hasDisease;
  }


}
