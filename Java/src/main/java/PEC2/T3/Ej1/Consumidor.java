package main.java.PEC2.T3.Ej1;

public class Consumidor extends Thread {

    private int numMensajes;

    private Buzon miBuzon;


    public Consumidor(int numMensajes, Buzon miBuzon) {

        this.numMensajes = numMensajes;

        this.miBuzon = miBuzon;

    }


    @Override

    public void run() {

        for (int i = 0; i < numMensajes; i++) {

            try {

                sleep((int) (500 + 500 * Math.random()));

            } catch (InterruptedException e) {
            }

            System.out.println(miBuzon.recibeMensaje());

        }

        System.out.println("Total mensajes leídos: " + numMensajes);

    }

}