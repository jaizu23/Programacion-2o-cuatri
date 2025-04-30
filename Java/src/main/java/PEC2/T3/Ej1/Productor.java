package main.java.PEC2.T3.Ej1;

public class Productor extends Thread {

    private String prefijo;

    private int numMensajes;

    private Buzon miBuzon;


    public Productor(String prefijo, int n, Buzon buzon) {

        this.prefijo = prefijo;

        numMensajes = n;

        miBuzon = buzon;

    }

    @Override
    public void run() {

        for (int i = 1; i <= numMensajes; i++) {

            try {

                sleep((int) (500 + 500 * Math.random()));

            } catch (InterruptedException e) {
            }

            miBuzon.enviaMensaje(prefijo + i);

        }

    }

}

