package main.java.PEC2.T5.Ejercicio4;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;
/*
 * En esta solución al problema del puente, se modifica el monitor para
 * que haya dos colas de threads esperando por la condición que les
 * permita progresar. Esto lo conseguimos mediante los objetos izqDch
 * y dchIzq de la clase java.util.concurrent.Condition.
 * De esta forma, los vehículos en sentido izq->dch esperan con izqDch.await();
 * pero son "despertados" por el último vehículo en sentido contrario con izqDch.signalAll();
 *
 * Para garantizar la exclusión mutua, como ya no tenemos métodos synchronized, usamos
 * el Lock (cerrojo) cerrando al comienzo (lock.lock();) y liberando al final (lock.unlock();).
 */
public class Puente
{
    private ListaThreads esperanID, esperanDI, dentro;
    private int cuenta=0;
    private int esperandoIzqDch=0, esperandoDchIzq=0;
    private int pasandoIzqDch=0, pasandoDchIzq=0;
    private Semaphore dentroPuente = new Semaphore(8,true);
    private Lock lock = new ReentrantLock();
    private Condition izqDch = lock.newCondition();
    private Condition dchIzq = lock.newCondition();
    private Condition parado = lock.newCondition();
    private boolean parar = false;
    private Label sentido;

    public Puente(TextField c1, TextField c2, TextField c3, Label l4)
    {
        esperanID = new ListaThreads(c1);
        esperanDI = new ListaThreads(c2);
        dentro = new ListaThreads(c3);
        sentido=l4;
    }

    public void llegarPuente(int num) throws InterruptedException
    {
        lock.lock();
        try
        {
            switch (num%2)
            {
                case 0: //Si es par, su sentido será izda -> dcha
                    esperanID.meter(currentThread());
                    esperandoIzqDch++;
                    while ((pasandoDchIzq!=0)||(cuenta>=5))
                    {
                        izqDch.await();
                    }
                    
                    esperanID.sacar(currentThread());
                    esperandoIzqDch--;
                    if(esperandoDchIzq>0)
                    {
                        cuenta++;
                    }
                    pasandoIzqDch++;
                    return;
                case 1: //Si es impar, su sentido será dcha -> izda
                    esperanDI.meter(currentThread());
                    esperandoDchIzq++;
                    while ((pasandoIzqDch!=0)||(cuenta>=5))
                    {
                        dchIzq.await();
                    }
                    
                    esperanDI.sacar(currentThread());
                    esperandoDchIzq--;
                    if(esperandoIzqDch>0)
                    {
                        cuenta++;
                    }
                    pasandoDchIzq++;
                    return;
            }
        }
        finally
        {
           lock.unlock();
        }
    }
    
    public void pasarPuente(int num)
    {
        lock.lock();
        try
        {
            try
            {
                dentroPuente.acquire(); //Ocupo un hueco en el puente
            } catch(InterruptedException e){}
            dentro.meter(currentThread());

            if(num%2==0)
            {
                Platform.runLater(() -> {
                    sentido.setText("Sentido: izquierda -> derecha");
                });
                System.out.println("num1: "+num);
            }
            else
            {
                Platform.runLater(() -> {
                    sentido.setText("Sentido: derecha -> izquierda");
                });
                System.out.println("num2: "+num);
            }
            
            if (mirarSiParar())
            {
                try {
                    parado.await();
                } catch (InterruptedException ex) {
                    System.out.println("Error: " + ex.toString());
                }
            }
        }
        finally
        {
           lock.unlock();
        }
    }
    
    public void salirPuente(int num)
    {
        lock.lock();
        try
        {
            dentro.sacar(currentThread());
            dentroPuente.release(); //Libero un hueco en el puente
            switch (num%2)
            {
                case 0: //Si el vehículo es par, pasaba de izda a dcha
                    pasandoIzqDch--;
                    if (pasandoIzqDch==0) //Si es el último
                    {
                        cuenta=0; //Ponemos la cuenta a 0
                        dchIzq.signalAll(); //Y avisamos a los que quieren cruzar en el otro sentido
                    }
                    return;
                case 1: //Si el vehículo es impar, pasaba de dcha a izda
                    pasandoDchIzq--;
                    if (pasandoDchIzq==0) //Si es el último
                    {
                        cuenta=0; //Ponemos la cuenta a 0
                        izqDch.signalAll(); //Y avisamos a los que quieren cruzar en el otro sentido
                    }
                    return;
            }
        }
        finally
        {
           lock.unlock();
        }
    }
    
    public void parar()
    {
        this.parar = true;
    }
    
    public boolean mirarSiParar()
    {
        return this.parar;
    }
    
    public void continuar()
    {
        lock.lock();
        try
        {
            this.parar = false;
            parado.signalAll();
        }
        finally
        {
           lock.unlock();
        }
    }
}
