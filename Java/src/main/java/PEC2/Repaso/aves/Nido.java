package main.java.PEC2.Repaso.aves;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Nido {
    private Semaphore comedero = new Semaphore(2);
    private Random r = new Random();

    public void comer(pajaro p) {
        try {
            comedero.try
            if (p.getClass() == )
            comedero.acquire();
            System.out.println(p.getClass().toString() + " " + p.getid() + " ha comido");
            Thread.sleep(r.nextInt(3000, 5000));
        } catch (InterruptedException e) {}
        comedero.release();
    }
}
