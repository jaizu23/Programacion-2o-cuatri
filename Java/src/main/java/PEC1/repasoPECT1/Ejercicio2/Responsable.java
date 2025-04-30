package main.java.PEC1.repasoPECT1.Ejercicio2;

/**
 * El último estudiante que deposite su voto avisará a una persona responsable 
 * de comunicar al estudiante seleccionado, mostrando un mensaje por pantalla. 
 */
public class Responsable extends Thread 
{       
    private Urna urna;

    public Responsable(Urna urna)
    {
        this.urna=urna;
    }
    
    public void run()
    {
        //Buscar quién es el ganador e imprimirlo por pantalla
        urna.recuentoVotos();
    }
}
