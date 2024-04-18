package hn.unah.matricula.util;

import java.time.Year;



public class AlumnoUtil {
  public static String crearNumeroCuenta() {
    String year = Integer.toString(Year.now().getValue());

    String siguientesDigitos = "";
    for(int i = 0; i < 7; i++) 
      siguientesDigitos += Integer.toString((int) Math.floor(Math.random() * 10));
   
    String numeroCuenta = year + siguientesDigitos;
    
    return numeroCuenta;
  }

  public static String generarCorreo(String nombre, String apellido, int contador) {

    if (null == nombre) {
      return " ";
    }
    String[] nombres = nombre.split(" ");
    String[] apellidos = apellido.split(" ");
 
    //char letraSegundoNombre = nombres[1].charAt(contador);
    //char letraSegundoApellido = apellidos[1].charAt(contador);

    String correo;
    //if (contador != 0 ) {
    //  correo = nombres[0] + apellidos[0] + letraSegundoNombre + letraSegundoApellido + "@unah.hn";
   // }
    correo = nombres[0] + apellidos[0] + "@unah.hn";

    return correo;
  }

}
