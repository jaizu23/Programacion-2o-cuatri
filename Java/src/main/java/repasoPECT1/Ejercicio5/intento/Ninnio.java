package main.java.repasoPECT1.Ejercicio5.intento;

import java.util.Random;

public class Ninnio extends Thread {
    private int id;
    private Columpio columpio;

    public Ninnio (Columpio columpio, int id) {
        this.id = id;
        this.columpio = columpio;
    }

    public void run() {
        Random r = new Random();
        for (int i = 0; i < 30; i++) {
            try {
                System.out.println("El niño #" + id + " ha empezado a jugar.");
                sleep(r.nextLong(1000, 20000));

                System.out.println("El niño #" + id + " va al columpio.");
                columpio.entrar(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
