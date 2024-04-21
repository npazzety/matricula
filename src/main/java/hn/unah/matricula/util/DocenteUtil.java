package hn.unah.matricula.util;

import java.util.HashSet;

public class DocenteUtil {

  private static HashSet<String> claves = new HashSet<>();

  public static String generarClave() {
    String clave = "";

    do {
      for (int i = 0; i < 7; i++) {
        clave += Integer.toString((int) Math.floor(Math.random() * 10));
      }
    } while(claves.contains(clave));

    claves.add(clave);

    return clave;
  }
}
