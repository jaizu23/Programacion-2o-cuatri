package main.java.PEC2.Repaso.Ej3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Ana Castillo
 */
public class Circuito {

    CyclicBarrier cb_llegadaCircuito = new CyclicBarrier(22);
    CountDownLatch cdl_vueltaReconomiento = new CountDownLatch(2);
    CountDownLatch cdl_carrera = new CountDownLatch(20);
    private RaceCar ganador;

    public void llegadaCircuito(int id) {
        try {
            System.out.println("El coche " + id + " HA LLEGADO al circuito");
            //espero a que lleguen todos los raceCars al circuito
            cb_llegadaCircuito.await();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la llegada del coche " + id + ": " + ex.toString());
        } catch (BrokenBarrierException ex) {
            System.out.println("BrokenBarrierException en la llegada del coche " + id + ": " + ex.toString());
        }
    }

    public void vueltaReconocimientoSafetyCars(SafetyCar safetyCar) {
        //Iniciar la vuelta de reconocimiento
        Random r = new Random();
        System.out.println("SafetyCar " + safetyCar.getIdSafetyCar() + " inicia vuelta de RECONOCIMIENTO");
        try {
            Thread.sleep(20000 + r.nextInt(10000));// 20 a 30 segundos
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la espera a la vuelta de reconociminto del Coche " + safetyCar.getIdSafetyCar() + ":" + ex.toString());
        }
        System.out.println("SafetyCar " + safetyCar.getIdSafetyCar() + " completa vuelta de RECONOCIMIENTO");
        cdl_vueltaReconomiento.countDown();
    }

    public void correrCarrera(RaceCar raceCar) {
        //espero a que los safety hayan acabado
        try {
            cdl_vueltaReconomiento.await();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la espera a la vuelta de reconociminto del Coche " + raceCar.getIdRaceCar() + ":" + ex.toString());
        }
        //inicio la carrera
        Random r = new Random();
        System.out.println("RaceCar " + raceCar.getIdRaceCar() + " inicia la CARRERA");
        try {
            Thread.sleep(20000 + r.nextInt(10000));// 20 a 30 segundos
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la carrera del Coche " + raceCar.getIdRaceCar() + ":" + ex.toString());
        }
        synchronized (cdl_carrera) {
            System.out.println("RaceCar " + raceCar.getIdRaceCar() + " finaliza la CARRERA");
            cdl_carrera.countDown();
            if (cdl_carrera.getCount() == 19) {
                System.out.println("RaceCar " + raceCar.getIdRaceCar() + " GANA LA CARRERA");
                ganador = raceCar;
            }
        }
    }

    public void vueltaFinalSafetyCars(SafetyCar safetyCar) {
        //una vez llegan todos a la meta, salen los dos safety e indican el ganador
        try {
            cdl_carrera.await();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la espera a la vuelta de final del Coche " + safetyCar.getIdSafetyCar() + ":" + ex.toString());
        }
        System.out.println("El ganador es " + ganador.getIdRaceCar());
    }
}
