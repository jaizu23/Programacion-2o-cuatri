package main.java.PEC1.sesion2.Ej3;

import java.awt.Color;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// La clase Paleta contiene los cuatro colores del parchís y los sirve a los pintores

public class Paleta

{

    private Color [] colores = new Color[4];



    private HashMap<Color, Lock> locks = new HashMap<>();



    public Paleta()

    {

        colores[0]=Color.red;

        colores[1]=Color.blue;

        colores[2]=Color.green;

        colores[3]=Color.yellow;

        for (int j=0; j<4; j++) {
            locks.put(colores[j],new ReentrantLock());
        }
    }

    public Color tomaColor()

    {

        int i = (int)(4 * Math.random());  //Elige color al azar

        int j = 0;
        while (j < 4) {
            if (locks.get(colores[j]).tryLock()) {
                break;
            } else {
                j++;
            }
        }
        return colores[j];
    }

    public HashMap<Color, Lock> getLocks() {
        return locks;
    }
}