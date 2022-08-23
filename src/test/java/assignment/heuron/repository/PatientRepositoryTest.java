package assignment.heuron.repository;

import static org.junit.jupiter.api.Assertions.*;

import assignment.heuron.domain.Patient;
import assignment.heuron.domain.PatientGender;
import assignment.heuron.domain.SaveLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PatientRepositoryTest {

  @Autowired
  PatientRepository patientRepository;

  @Nested
  @DisplayName("환자 정보 저장")
  class SavePatient {

    @Test
    @DisplayName("환자 정보가 모두 있는 경우")
    public void patientDataAllExist() {
      //given
      Patient patient = Patient.builder()
          .patientName("patientZ")
          .patientAge(38)
          .patientGender(PatientGender.WOMAN)
          .hasDisease(true)
          .build();

      //when
      Patient savePatient = patientRepository.save(patient);

      //then
      Assertions.assertEquals("patientZ", savePatient.getPatientName());
    }

    @Test
    @DisplayName("환자 정보가 일부만 있는 경우")
    public void patientDataPartExist() {
      //given
      Patient patient = Patient.builder()
          .patientName("patientZ")
          .patientAge(38)
          .build();

      //when
      Patient savePatient = patientRepository.save(patient);

      //then
      Assertions.assertEquals(null, savePatient.getPatientGender());

      //null값으로 들어감... validation 적용 필요?

    }

    @Test
    @DisplayName("사진 정보가 없는 경우")
    public void imageNotExist() {
      //given
      Patient patient = Patient.builder()
          .patientName("patientZ")
          .patientAge(38)
          .patientGender(PatientGender.WOMAN)
          .hasDisease(true)
          .build();

      //when
      Patient savePatient = patientRepository.save(patient);

      //then
      Assertions.assertEquals(SaveLevel.LEVEL1, savePatient.getSaveLevel());
    }

    @Test
    @DisplayName("사진 정보만 있는 경우")
    public void onlyImageExist() {
      //postman으로 확인했을 때는 Bad Request가 뜬다, 하지만 영속성 계층에서 직접 저장하면 저장이 된다.
    }

    @Test
    @DisplayName("환자 정보가 모두 없는 경우")
    public void patientDataNotExist() {
    }

  }

  @Nested
  @DisplayName("환자 정보 조회")
  class ReadPatient {

    @Test
    @DisplayName("환자 정보가 모두 있는 경우")
    public void patientDataAllExist() {
    }

    @Test
    @DisplayName("환자 정보가 일부만 있는 경우")
    public void patientDataPartExist() {
    }

    @Test
    @DisplayName("사진 정보가 없는 경우")
    public void imageNotExist() {
    }

    @Test
    @DisplayName("사진 정보만 있는 경우")
    public void onlyImageExist() {
    }

    @Test
    @DisplayName("환자 정보가 모두 없는 경우")
    public void patientDataNotExist() {
    }

  }


}