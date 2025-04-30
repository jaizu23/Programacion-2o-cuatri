package main.java.PEC2.Repaso.Ej4;

import java.util.concurrent.Callable;

/**
 *
 * @author Ana Castillo
 */
public class TareaFundicion implements Callable<Boolean> {

    private int id;

    public TareaFundicion(int id) {
        this.id = id;
    }

    public Boolean call() {
        System.out.println("Tarea de fundición " + id + " iniciada");
        boolean terminado = false;
        try {
            Thread.sleep(12000);
            terminado = true;
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la tarea de fundición :" + ex.toString());
            terminado = false;
        }
        System.out.println("Tarea de fundición " + id + " finalizada");
        return terminado;
    }
}
