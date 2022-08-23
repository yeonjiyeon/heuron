package assignment.heuron.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PatientServiceImplTest {
  @Nested
  @DisplayName("환자 정보 저장")
  class SavePatient{
    @Test
    @DisplayName("환자 정보가 모두 있는 경우")
    public void patientDataAllExist(){}

    @Test
    @DisplayName("환자 정보가 일부만 있는 경우")
    public void patientDataPartExist(){}

    @Test
    @DisplayName("사진 정보가 없는 경우")
    public void imageNotExist(){}

    @Test
    @DisplayName("사진 정보만 있는 경우")
    public void onlyImageExist(){}

    @Test
    @DisplayName("환자 정보가 모두 없는 경우")
    public void patientDataNotExist(){}

  }

  @Nested
  @DisplayName("환자 정보 저장")
  class ReadPatient{
    @Test
    @DisplayName("환자 정보가 모두 있는 경우")
    public void patientDataAllExist(){}

    @Test
    @DisplayName("환자 정보가 일부만 있는 경우")
    public void patientDataPartExist(){}

    @Test
    @DisplayName("사진 정보가 없는 경우")
    public void imageNotExist(){}

    @Test
    @DisplayName("사진 정보만 있는 경우")
    public void onlyImageExist(){}

    @Test
    @DisplayName("환자 정보가 모두 없는 경우")
    public void patientDataNotExist(){}

  }
}