package assignment.heuron.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class FileServiceImpl implements FileService {

  @Override
  public String uploadFile(MultipartFile imageFile) throws IOException {
    String originName = imageFile.getOriginalFilename();

    String imageSavePath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

    UUID uuid = UUID.randomUUID();
    String fileName = uuid + "_" + originName;

    File file = new File(imageSavePath, fileName);
    imageFile.transferTo(file);

    return fileName;
  }
}
