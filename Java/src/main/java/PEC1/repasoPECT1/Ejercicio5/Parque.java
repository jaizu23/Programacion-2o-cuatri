package main.java.PEC1.repasoPECT1.Ejercicio5;

import static java.lang.Thread.sleep;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parque {

    private Lock cerrojo = new ReentrantLock();

    public void entrarColumpio(int idNinio) {
        
        try //try para asegurar el trylock
        { 
            boolean hajugado = false;
            int tiempoespera = 5 + (int) (Math.random() * 5);
            
            //Nos aseguramos de haber obtenido el cerrojo para ejecutar el código
            if (cerrojo.tryLock(tiempoespera, TimeUnit.SECONDS))
            {
                try //try para asegurar que abrimos el cerrojo si lo hemos obtenido
                {
                    System.out.println("Columpio -> Ninio " + idNinio + " toma el columpio");
                    sleep(3000);
                    System.out.println("Columpio -> libre");
                } catch (InterruptedException e) 
                {
                    System.out.println("Error al jugar en el columpio");
                } finally 
                {
                    cerrojo.unlock();
                }                
            }else
            {
                System.out.println("Ninio " + idNinio + " no puede tomar el columpio y se va a jugar");                
            }
        } catch (InterruptedException ex) 
        {
            System.out.println("Error al jugar en el columpio");
        }
    }
}
