package hn.unah.matricula.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ImageStorage {

  private static final String FOLDER_PATH = "\\Users\\Carlo\\OneDrive\\carlos-unah\\unah-2024\\IP\\lenguajes\\img-back"; 

  public static String saveImage(MultipartFile image) throws IOException {
    String filepath = FOLDER_PATH + image.getOriginalFilename();
    image.transferTo(new File(filepath));
    return filepath;
  }
}
