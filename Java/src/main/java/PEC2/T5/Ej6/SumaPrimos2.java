package main.java.PEC2.T5.Ej6;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SumaPrimos2

{


    public static void main(String[] x)

    {
        Lock lock = new ReentrantLock();
        Resultado suma = new Resultado();

        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("Suma: " + suma.getSuma()));

        long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos

        Calculador p1 = new Calculador(1,2000000,suma, lock, barrier);

        Calculador p2 = new Calculador(2000001,4000000,suma, lock, barrier);

        Calculador p3 = new Calculador(4000001,6000000,suma, lock, barrier);

        Calculador p4 = new Calculador(6000001,8000000,suma, lock, barrier);

        Calculador p5 = new Calculador(8000001,10000000,suma, lock, barrier);

        p1.start();

        p2.start();

        p3.start();

        p4.start();

        p5.start();


        long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos


    }

}
