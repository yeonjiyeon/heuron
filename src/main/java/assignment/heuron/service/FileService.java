package assignment.heuron.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

  public String uploadFile(MultipartFile imageFile) throws IOException;
}
