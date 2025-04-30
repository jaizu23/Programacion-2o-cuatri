package main.java.PEC2.T5.Ejercicio1;

import javafx.scene.control.TextArea;

import java.util.concurrent.Semaphore;

public class Exposicion {
    int aforo;
    ListaThreads colaEspera, dentro;
    Semaphore semaforo;
    public Exposicion(int aforo, TextArea txtFuera, TextArea txtDentro)
    {
        this.aforo=aforo;
        semaforo=new Semaphore(aforo,true); //El semáforo se crea como justo
        colaEspera=new ListaThreads(txtFuera);
        dentro=new ListaThreads(txtDentro);
    }

    public void entrar(Visitante v)
    {
        colaEspera.meter(v);
        try
        {
            semaforo.acquire();
        } catch(InterruptedException e){ }
        colaEspera.sacar(v);
        dentro.meter(v);
    }

    public void salir(Visitante v)
    {
        dentro.sacar(v);
        semaforo.release();
    }

    public void mirar(Visitante v)
    {
        try
        {
            Thread.sleep(2000+(int)(3000*Math.random()));
        } catch (InterruptedException e){ }
    }
}
