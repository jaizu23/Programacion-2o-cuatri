package main.java.PEC1.repasoPECT1.Ejercicio1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Sistema domótico compuesto por varios sensores de temperatura y un display 
 * que mostrará la temperatura promedia.
 */
public class SistemaDomotico {
    
    private int temperatura1;
    private int temperatura2;
    private int display;
    Lock cerrojo = new ReentrantLock(); //Cerrojo para garantizar exclusión mútua
    
    public SistemaDomotico()
    {
        this.temperatura1=0;
        this.temperatura2=0;
        this.display=0;
    }
    
    public void escribirTemperatura(int temperatura, int id)
    {
        /**Se utiliza el mismo cerrojo que en calcular media para garantizar 
         * que no hay cambios durante esa operación */
        cerrojo.lock();
        try
        {
            
        switch (id) 
        {
            case 1 -> this.temperatura1 = temperatura;
            case 2 -> this.temperatura2 = temperatura;          
        }
        }catch(Exception e)
        {
            System.out.println("Error al escribir la temperatura: " + e.toString());
        }
        finally
        {
            cerrojo.unlock();
        }
    }
    
    public void calcularMedia()
    {
        try
        {
            cerrojo.lock();
            display = (temperatura1 + temperatura2) / 2;
        }catch(Exception e)
        {
            System.out.println("Error al calcular la media: " + e.toString());
        }finally
        {
            cerrojo.unlock();
        }
    }

    public int getDisplay() 
    {
        
        calcularMedia();
        return display;
    }
 }
