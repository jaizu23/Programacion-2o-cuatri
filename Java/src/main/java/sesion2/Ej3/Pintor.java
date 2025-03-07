package main.java.sesion2.Ej3;

import java.awt.Color;

import javax.swing.JButton;



public class Pintor extends Thread

{

    private JButton b;

    private Paleta p;

    private Color negro = Color.black;



    public Pintor(JButton b, Paleta p)

    {

        this.b=b;

        this.p=p;

    }



    public void run()

    {

        long tiempoEnNegro = 0;

        long tiempoEnColor = 0;



        while (true)

        {

            tiempoEnNegro = (long) 2000 + (int)((4000-2000)*Math.random());

            tiempoEnColor = (long) 3000 + (int)((5000-3000)*Math.random());



            b.setBackground(negro);  //Pinta el botón de negro

            try

            {

                sleep(tiempoEnNegro); // Espera entre 2 y 4 segundos

            } catch (InterruptedException e){}


            Color color = p.tomaColor();
            b.setBackground(color);   //Pinta el botón con el color aleatorio

            try

            {

                sleep(tiempoEnColor); //Espera entre 3 y 5 segundos

            } catch (InterruptedException e){}

            p.getLocks().get(color).unlock();
        }

    }

}
