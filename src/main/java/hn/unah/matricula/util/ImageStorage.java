package hn.unah.matricula.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ImageStorage {

  private static String FOLDER_PATH = "C:\\wamp64\\www\\proyecto-matricula-frontend\\public\\images\\".replace("\\", "/"); 


  public static String saveImage(MultipartFile image) throws IOException {
    String filepath = FOLDER_PATH + image.getOriginalFilename();
    image.transferTo(new File(filepath));
    return filepath;
  }
}
