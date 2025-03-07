package main.java.repasoPECT1.Ejercicio2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Sistema de votación para seleccionar a un candidato, de entre tres 
 * propuestos, para ser delegado de clase
 */

public class Urna 
{    
    private int votos1;
    private int votos2;
    private int votos3;

    Lock cerrojo = new ReentrantLock();
        
    public Urna()
    {

    }
    
    public void votar(int idEstudiante, int candidato)
    {
        //Garantizamos la excusión mútua y que los votos lleguen de uno en uno
        cerrojo.lock();
        try
        {       
            //Añadimos el voto del candidato
            switch (candidato) 
            {
                case 1 -> votos1++;
                case 2 -> votos2++;
                case 3 -> votos3++;
            }
            
            System.out.println("El estudiante " + idEstudiante + " ha depositado su voto por el candidato " 
                    +candidato+". Votos totales: " + (votos1+votos2+votos3));

            //Si se ha contabilizado el último voto se llama al hilo responsable
            if((votos1+votos2+votos3)==80)
            {
                Responsable r = new Responsable(this);
                r.start();
            } 
        }catch(Exception e)
        {
            System.out.println("Error en el cerrojo " + e.toString());
        }finally
        {
            cerrojo.unlock();
        }
    }
    
    public void recuentoVotos()
    {
        if(votos1>votos2 && votos1>votos3)
        {
            System.out.println("El ganador es el candidato 1");
        }else
        {
            if(votos2>votos1 && votos2>votos3)
            {
                System.out.println("El ganador es el candidato 2");
            }else
            {
                if(votos3>votos1 && votos3>votos2)
                {
                    System.out.println("El ganador es el candidato 3");
                }else
                {
                    System.out.println("Hay un empate. Es neceario repetir las elecciones");
                }
            }
        }
    }
}
