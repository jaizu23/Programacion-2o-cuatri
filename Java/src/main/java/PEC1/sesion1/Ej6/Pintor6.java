package main.java.PEC1.sesion1.Ej6;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Pintor6 extends Thread {

    JButton b;

    Color[] paleta = new Color[5];

    public Pintor6(JButton b){

        this.b=b;

        paleta[0]=Color.BLACK;

        paleta[1]=Color.RED;

        paleta[2]=Color.GREEN;

        paleta[3]=Color.BLUE;

        paleta[4]=Color.YELLOW;

    }

    public void run(){
        Random r = new Random();

        while (true){
            try {
                b.setBackground(paleta[0]);

                long i = 1000 * r.nextLong(2,5);
                sleep(i);

                int j = r.nextInt(1,5);
                b.setBackground(paleta[j]);

                long k = 1000 * r.nextLong(3,6);
                sleep(k);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}