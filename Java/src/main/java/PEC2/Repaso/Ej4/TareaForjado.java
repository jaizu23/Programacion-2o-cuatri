package main.java.PEC2.Repaso.Ej4;

import java.util.ArrayList;

/**
 *
 * @author Ana Castillo
 */
public class TareaForjado implements Runnable {

    private int id;
    private ArrayList<Integer> listIdFundicion;

    public TareaForjado(int id, ArrayList<Integer> listIdFundicion) {
        this.id = id;
        this.listIdFundicion = listIdFundicion;
    }

    public void run() {
        System.out.println("Tarea de forjado " + id + " iniciada con bloques " + listIdFundicion.toString());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la tarea de forjado :" + ex.toString());
        }
        System.out.println("Tarea de forjado " + id + " finalizada con bloques " + listIdFundicion.toString());
    }
}
