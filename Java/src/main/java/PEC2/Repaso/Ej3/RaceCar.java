package main.java.PEC2.Repaso.Ej3;

import java.util.Random;

/**
 *
 * @author Ana Castillo
 */
public class RaceCar extends Thread {

    private int id;
    private Circuito circuito;

    public RaceCar(int id, Circuito circuito) {
        this.id = id;
        this.circuito = circuito;
    }

    @Override
    public void run() {
        //llegada al circuito
        System.out.println("RaceCar " + id + " LLEGANDO al circuito");
        Random r = new Random();
        try {
            Thread.sleep(4000 + r.nextInt(16000));// 4 a 16 segundos
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la llegada del coche de carreras " + id + ": " + ex.toString());
        }
        circuito.llegadaCircuito(id);

        //comienza la carrera
        circuito.correrCarrera(this);
    }

    public int getIdRaceCar() {
        return this.id;
    }

}
