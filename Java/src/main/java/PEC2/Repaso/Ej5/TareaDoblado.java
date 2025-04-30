package main.java.PEC2.Repaso.Ej5;

import java.util.concurrent.Callable;

/**
 *
 * @author Ana Castillo
 */
public class TareaDoblado implements Callable<Prenda> {

    private int id;
    private Prenda p;

    public TareaDoblado(int id, Prenda p) {
        this.id = id;
        this.p = p;
    }

    public Prenda call() {
        System.out.println("Tarea de doblado " + id + " iniciada. Tipo de prenda: " + p.getTipoString());
        try {
            Thread.sleep(100);
            p.setDoblada(true);
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException al doblar la prenda: " + ex.toString());
            return p;
        }
        //System.out.println("Tarea de doblado " + id + " finalizada");
        return p;
    }
}
