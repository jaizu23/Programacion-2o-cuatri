package main.java.PEC1.repasoPECT1.Examen2023.opcion1;

import java.util.Date;

import static java.lang.Thread.sleep;

/**
 *
 */
public class Examen 
{
    public static void main(String[] args) 
    {
        // instanciar el elemento común
        Academia academia = new Academia();
        
        //Instanciar y arrancar los estudiantes
        for (int i = 1; i <= 100; i++) 
        {
            try {
                int ciclo = i / 26;
                int resto = i % 26;
                StringBuilder nombre = new StringBuilder();
                nombre.append((char) ('A' + ciclo));
                nombre.append((char) ('A' + resto));
                System.out.println(nombre);
//                int idioma = 1+ (i%2); //Asignamos el idioma según si es par o no
//                Estudiante estudiante = new Estudiante (i, idioma, academia);
//                estudiante.start();
                sleep(5);
            } catch (InterruptedException ex) {
                System.out.println("Error al crear un estudiante");
                Date fecha = new Date();
            }
        }
    }
    
}
