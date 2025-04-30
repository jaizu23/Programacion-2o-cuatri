package main.java.PEC2.T5.Ej5;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Exchanger;

// Pintor es un hilo que hace que el botón cambie de color siguiendo la secuencia:

// 1. Se pinta de negro durante un tiempo aleatorio que varía entre un mínimo de 0 y un máximo de 0.2 segundos.

// 2. Obtiene el primer color que le corresponde y pinta con ese color

// 3. Espera entre 0 y 0.05 segundos

// 4. Toma el segundo color, lo mezcla con el primero y pinta con la mezcla

// 5. Espera entre 0 y 0.1 seg. y vuelve a empezar el ciclo.

public class Pintor extends Thread {

    private JButton b;

    private Paleta p;

    private int numPintor;

    private Color negro = Color.black;

    private Color color;

    private Exchanger<Color>[] ex;


    public Pintor(JButton b, Paleta p, int numPintor, Exchanger<Color> ex1, Exchanger<Color> ex2) {

        this.b = b;

        this.p = p;

        this.numPintor = numPintor;

        this.color = p.tomaColor(numPintor);
    }


    public void run() {

        while (true) {

            b.setBackground(negro);                 //Pinta el botón de negro

            try {

                sleep((int) (200 * Math.random()));    //Espera entre 0 y 0.2 seg.

            } catch (InterruptedException e) {
            }

            b.setBackground(color);                   //y pinta el botón

            try {

                sleep((int) (50 * Math.random()));     //Espera entre 0 y 0.05 seg.

            } catch (InterruptedException e) {
            }



            try {

                sleep((int) (100 * Math.random()));  //Espera entre 0 y 0.1 seg.

            } catch (InterruptedException e) {
            }


            p.dejaColor(numPintor + 1);

        }

    }

}
