package main.java.PEC2.Examen_info_2025.Ej1;

import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            Vehiculo v = new Vehiculo();
            v.start();
            try {
                Thread.sleep(1000 * r.nextLong(3,6));
            } catch (InterruptedException e) {}
        }
    }
}
