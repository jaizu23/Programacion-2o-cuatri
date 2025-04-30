package main.java.PEC2.Repaso.Ej2;

import java.util.Random;

/**
 *
 * @author Ana Castillo
 */
public class Persona extends Thread {

    private int id;
    private Museo museo;

    public Persona(int id, Museo museo) {
        this.id = id;
        this.museo = museo;
    }

    @Override
    public void run() {
        Random r = new Random();
        if (r.nextDouble() < 0.5) {
            museo.entrar_museo_este(this);
        } else {
            museo.entrar_museo_oeste(this);
        }
        try {
            Thread.sleep(500 + r.nextInt(1000));
        } catch (InterruptedException ex) {
            System.out.println("Error en la ejecución de la personal: " + ex.toString());
        }
        museo.salir_museo(this);
    }

    // Getter para saber el id de la persona
    public int getIdPersona() {
        return this.id;
    }
}
