package assignment.heuron.service;

import assignment.heuron.domain.Patient;
import assignment.heuron.domain.SaveLevel;
import assignment.heuron.dto.request.PatientRequest;
import assignment.heuron.dto.response.PatientResponse;
import assignment.heuron.repository.PatientRepository;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {


  private final PatientRepository patientRepository;


  //이미지 저장
  public String uploadFile(MultipartFile imageFile) throws Exception {

    String originName = imageFile.getOriginalFilename();

    String imageSavePath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

    UUID uuid = UUID.randomUUID();
    String fileName = uuid + "_" + originName;

    File file = new File(imageSavePath, fileName);
    imageFile.transferTo(file);

    return fileName;
  }

  //저장 API
  @Override
  public Long savePatient(PatientRequest patientRequest, MultipartFile imageFile) throws Exception {
    Patient patient = dtoToEntity(patientRequest);
    if (imageFile != null) {
      String imageName = uploadFile(imageFile);
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


  //이미지 조회 API
  @Override
  public byte[] readImage(String imagePath) throws Exception {

    FileInputStream inputStream = null;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    String imageSavePath = System.getProperty("user.dir") + "/src/main/resources/static/files/";
    try {
      inputStream = new FileInputStream(imageSavePath + imagePath);
    } catch (FileNotFoundException e) {
      throw new Exception("해당 파일을 찾을 수 없습니다.");
    }

    int readCount = 0;
    byte[] buffer = new byte[1024];
    byte[] fileArray = null;

    try {
      while ((readCount = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, readCount);
      }
      fileArray = outputStream.toByteArray();
      inputStream.close();
      outputStream.close();

    } catch (IOException e) {
      throw new Exception("파일을 변환하는데 문제가 발생했습니다.");
    }

    return fileArray;
  }


}
