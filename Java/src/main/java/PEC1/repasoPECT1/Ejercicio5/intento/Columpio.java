package main.java.PEC1.repasoPECT1.Ejercicio5.intento;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Columpio {
    private Lock lock = new ReentrantLock();
    Random r = new Random();

    public void entrar(int id) {
        try {
            if(lock.tryLock(r.nextInt(5000, 10000), TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(id + " entro a jugar al columpio");
                    sleep(3000);
                    System.out.println(id + " termino de jugar al columpio");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(id + " desistio de entrar al columpio");
            }
        } catch (InterruptedException e) {
            System.out.println("Error del niño #" + id + " al entrar en el columpio.");
        }
    }
}
