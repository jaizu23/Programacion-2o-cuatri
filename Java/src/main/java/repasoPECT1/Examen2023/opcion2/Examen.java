package main.java.repasoPECT1.Examen2023.opcion2;

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
                int idioma = (i%2); //Asignamos el idioma según si es par o no
                Estudiante estudiante = new Estudiante (i, idioma, academia);
                estudiante.start();
                sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Error al crear un estudiante");
            }
        }
    }
    
}
