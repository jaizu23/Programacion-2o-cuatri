package main.java.PEC2.T5.Ej3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PistaTenis {
    private final Semaphore semaforo = new Semaphore(2);
    private final CyclicBarrier barrera = new CyclicBarrier(2);
    private final AtomicInteger estadoPista = new AtomicInteger(0);
    private final AtomicBoolean enJueg = new AtomicBoolean(false);

    public synchronized void jugar (Tenista tenista) {
        try {
            if (tenista.getid() % 2 == 0) {
                while (estadoPista.get() == 2 || estadoPista.get() == 3) {
                    System.out.println("Esperando " + tenista.getid());
                    wait();
                    if (semaforo.tryAcquire()) {
                        estadoPista.set(1);
                        System.out.println("En pista " + tenista.getid());
                        notifyAll();
                        break;
                    }
                }
            } else {
                while (estadoPista.get() == 1 || estadoPista.get() == 0) {
                    System.out.println("Esperando " + tenista.getid());
                    wait();
                    if (semaforo.tryAcquire()) {
                        estadoPista.set(2);
                        System.out.println("En pista " + tenista.getid());
                        notifyAll();
                        break;
                    }
                }
            }
            barrera.await();
            System.out.println("Jugando " + tenista.getid());
            Thread.sleep((int) (Math.random() * 500) + 500);
            estadoPista.set(0);
            notifyAll();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
