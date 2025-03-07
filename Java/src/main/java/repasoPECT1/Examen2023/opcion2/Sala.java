package main.java.repasoPECT1.Examen2023.opcion2;

import static java.lang.Thread.sleep;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Elemento genérico que sirve para representar cada elemento que contiene exclusión mútua
 */
public class Sala 
{
    private int tipo;
    private int contador;
    private Lock cerrojo;
    
    public Sala(int tipo)
    {
        this.tipo = tipo; //1-aula1, 2-aula2, 3-baño, 4-maquina expendedora, 5-máquina cafe
        this.contador=0;
        cerrojo = new ReentrantLock();
    }
    
    public void entrarSala(Estudiante estudiante, boolean entrada)
    {
        cerrojo.lock();
        try
        {
            if(tipo < 3) //tipo aula
            {
                sleep(1000);
                if(entrada)
                {
                    contador++;
                }else
                {
                    contador --;
                }
                System.out.println("Aula " + tipo +": Estudiante " + estudiante.getIdEstudiante() 
                        + ". Fecha: " + new Date()
                        +". Num Alumnos: " + contador);
            }else
            {
                if(tipo==3) //tipo baño
                {
                    sleep(3000);
                    System.out.println("El estudiante " + estudiante.getIdEstudiante() + " ha ido al baño");
                }else //Máquinas
                {
                    sleep(5000);
                    contador ++;
                    if(tipo==4)
                    {
                        System.out.println("El estudiante " + estudiante.getIdEstudiante() 
                                + " usa la máquina expendedora. Num usos: " + contador);
                    }else
                    {
                        
                        System.out.println("El estudiante " + estudiante.getIdEstudiante() 
                                + " usa la máquina de café. Num usos: " + contador);
                    }
                }
            }
        }catch(InterruptedException e)
        {
            System.out.println("Error al entrar en la sala del tipo " + tipo);
        }
        finally
        {
            cerrojo.unlock();
        }
    }
}
