package main.java.repasoPECT1.Ejercicio2;

import java.util.Random;

/**
 * cada uno de los 80 estudiantes presentes depositará su voto (el cual será 
 * aleatorio) en la urna de votación. El último estudiante que deposite su voto 
 * avisará a una persona responsable
 */
public class Estudiante extends Thread{
    private Urna urna;
    private int idEstudiante;
    
    public Estudiante (Urna urna, int idEstudiante)
    {
        this.urna=urna;
        this.idEstudiante=idEstudiante;
    }

    @Override
    public void run()
    {
        //Calcular el voto aleatorio y depositarlo en la urna
        int voto = (int)(3*Math.random() + 1);
        urna.votar(idEstudiante, voto);
    }
    
}
