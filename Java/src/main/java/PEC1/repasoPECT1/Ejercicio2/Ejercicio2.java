package main.java.PEC1.repasoPECT1.Ejercicio2;

/**
 *Se desea crear un sistema de votación para seleccionar a un candidato, de 
 * entre tres propuestos, para ser delegado de clase. Para ello, cada uno de los
 * 80 estudiantes presentes depositará su voto (el cual será aleatorio) en la 
 * urna de votación. El último estudiante que deposite su voto avisará a una 
 * persona responsable de comunicar al estudiante seleccionado, mostrando un 
 * mensaje por pantalla. Nota: el recuento debe llevarse a cabo de forma 
 * transparente a medida que los estudiantes depositan sus votos.
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        //Instanciar el elemento común
        Urna urna = new Urna();
        
        //Instanciar y arrancar a los hilos
        for (int i = 1; i <= 80; i++) {
            Estudiante estudiante = new Estudiante(urna, i);
            estudiante.start();
        }
    }
    
}
