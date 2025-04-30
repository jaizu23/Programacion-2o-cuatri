package main.java.PEC2.Repaso.Ej5;

/**
 *
 * @author Ana Castillo
 */
public class TareaEmpaquetado implements Runnable {

    private String tipo;

    public TareaEmpaquetado(String tipo) {
        this.tipo = tipo;
    }

    public void run() {
        System.out.println("Tarea de empaquetado de tipo " + tipo + " iniciada");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException al empaquetar las prendas: " + ex.toString());
        }
        System.out.println("Tarea de empaquetado de tipo " + tipo + " finalizada");
    }
}
