package main.java.PEC1.repasoPECT1.Ejercicio4;

import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Edificio 
{        
    //Cerrojos
    private Lock cerrojoCajetin;
    private Lock cerrojoCafetera;
    
    //Contadores
    private int numCafes;
    private int numTrabajadores;
    
    public Edificio()
    {
        numCafes=0;       
        numTrabajadores=0;
        cerrojoCajetin = new ReentrantLock();
        cerrojoCafetera = new ReentrantLock();        
    }
    
    public void fichar(Trabajador t, boolean entrada)
    {
        cerrojoCajetin.lock();
        try
        {
            sleep(1000);             
            Calendar cal = Calendar.getInstance();
            if(entrada) //El trabajado ficha la entrada
            {
                numTrabajadores++;
                System.out.println("El trabajador " + t.getIdTrabajador() + " ha fichado su entrada a las " 
                    + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE)
                    + ". Num trabajadores: " + numTrabajadores);
            }else //El trabajado ficha la salida
            {
                numTrabajadores--;
                System.out.println("El trabajador " + t.getIdTrabajador() + " ha fichado la salida a las " 
                    + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE)
                    + ". Num trabajadores: " + numTrabajadores);
            }
        }catch(InterruptedException e)
        {
            System.out.println("Error al fichar el trabajador " + t.getIdTrabajador() + ": " + e.toString());
        }finally
        {
            cerrojoCajetin.unlock();
        }
    }
    
    public void cafe(Trabajador t)
    {
        cerrojoCafetera.lock();
        try
        {
            sleep(5000);     
            numCafes++;
            System.out.println("El trabajador " + t.getIdTrabajador() + " se toma un café. Num cafés: " + numCafes);
        }catch(InterruptedException e)
        {
            System.out.println("Error al tomar café el trabajador " + t.getIdTrabajador() + ": " + e.toString());
        }finally
        {
            cerrojoCafetera.unlock();
        }
    }    
}
