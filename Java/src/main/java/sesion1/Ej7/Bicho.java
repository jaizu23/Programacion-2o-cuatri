package main.java.sesion1.Ej7;

import java.util.Random;

public class Bicho extends Thread{
    private int gen;
    private String nombre;

    public Bicho(int gen, String nombre) {
        this.gen = gen;
        this.nombre = nombre;
    }

    public void run(){
        try {
            long inicio = System.currentTimeMillis();
            System.out.println("NACE: " + nombre);

            Random r = new Random();
            int i = r.nextInt(500, 1000);
            sleep(i);

            if (gen < 5) {
                String nombreHijo = "";
                for (i = 0; i < 4; i++) {
                    char letra = (char) ('A' + Math.random() * 26);
                    nombreHijo += letra;
                }
                Bicho hijo = new Bicho(gen + 1, nombreHijo);
                hijo.start();

                hijo.join();
            }

            long fin = System.currentTimeMillis();

            System.out.println("MUERE: " + nombre + ", GEN: " + gen + ", TIEMPO VIDA: " + (fin-inicio) + " ms.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
