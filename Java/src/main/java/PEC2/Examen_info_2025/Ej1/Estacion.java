package main.java.PEC2.Examen_info_2025.Ej1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Estacion {
    private Semaphore surtidores = new Semaphore(4, true);
    private Semaphore registradoras = new Semaphore(2, true);

    public synchronized void entrar (Vehiculo v, boolean entra) {
        if (entra) {

        }
        System.out.println(v.getid() + "entrando");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.println(v.getid() + "ha entrado");
    }

    public void repostar(Vehiculo v) {
        try {
            surtidores.acquire();
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
    }
}
