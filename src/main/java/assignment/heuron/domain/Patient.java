package assignment.heuron.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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

  @Enumerated(value = EnumType.STRING)
  private PatientGender patientGender;

  private boolean hasDisease;

  private String imageName;

  private String imagePath;

  @Enumerated(value = EnumType.STRING)
  private SaveLevel saveLevel;

  @Builder
  public Patient(String patientName, int patientAge, PatientGender patientGender,
      boolean hasDisease) {
    this.patientName = patientName;
    this.patientAge = patientAge;
    this.patientGender = patientGender;
    this.hasDisease = hasDisease;
    this.saveLevel = SaveLevel.LEVEL1;
  }


  public void updateImageInfo(String imageName) {
    this.imageName = imageName;
    this.imagePath = "/files/" + imageName;
  }

  //저장 단계 수정
  public void updateSaveLevel(SaveLevel saveLevel) {
    this.saveLevel = saveLevel;
  }

  //저장 2 단계인지 확인 메서드
  public boolean isLevelTwo(SaveLevel saveLevel) {
    return (saveLevel == SaveLevel.LEVEL2) ? true : false;
  }

}
