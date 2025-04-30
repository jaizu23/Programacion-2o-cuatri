package main.java.PEC2.Repaso.Ej3;

import java.util.Random;

/**
 *
 * @author Ana Castillo
 */
public class SafetyCar extends Thread {

    private int id;
    private Circuito circuito;

    public SafetyCar(int id, Circuito circuito) {
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
            System.out.println("InterruptedException en la llegada del coche de seguridad " + id + ": " + ex.toString());
        }
        circuito.llegadaCircuito(id);

        // Se inicia la vuelta de reconocimiento, una vez están todos los raceCar en el circuito
        circuito.vueltaReconocimientoSafetyCars(this);

        //Se anuncia el ganador
        circuito.vueltaFinalSafetyCars(this);
    }

    public int getIdSafetyCar() {
        return this.id;
    }

}
