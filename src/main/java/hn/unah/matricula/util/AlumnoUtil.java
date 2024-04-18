package hn.unah.matricula.util;

import java.time.Year;
import java.util.HashSet;



public class AlumnoUtil {

  private static HashSet<String> correosGenerados = new HashSet<>();
  private static final String dominioCorreo = "@unah.hn";  

  public static String crearNumeroCuenta() {
    String year = Integer.toString(Year.now().getValue());

    String siguientesDigitos = "";
    for(int i = 0; i < 7; i++) 
      siguientesDigitos += Integer.toString((int) Math.floor(Math.random() * 10));
   
    String numeroCuenta = year + siguientesDigitos;
    
    return numeroCuenta;
  }

  public static String generarCorreo(String nombre, String apellido) {

    if (null == nombre) {
      return " ";
    }
    String[] nombres = nombre.split(" ");
    String[] apellidos = apellido.split(" ");
    
    String primerNombre = nombres[0];
    String primerApellido = apellidos[0];

    int maxPrimerNombre = primerNombre.length() - 1;
    String correo = "";

    do {
      correo = primerNombre.charAt((int) Math.floor(Math.random() * maxPrimerNombre)) + primerNombre.charAt((int) Math.floor(Math.random() * maxPrimerNombre)) + primerApellido + dominioCorreo;
    } while(correosGenerados.contains(correo));

    correosGenerados.add(correo);


    return correo;
  }

}
