package main.java.PEC2.T5.Ej6;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Calculador extends Thread

{

    private CyclicBarrier barrier;
    int desde, hasta;

    Resultado r;

    private Lock lock;

    public Calculador(int x, int y, Resultado r, Lock lock, CyclicBarrier barrier)

    {
        this.barrier = barrier;

        desde=x;

        hasta=y;

        this.r=r;

        this.lock=lock;
    }



    public void run()

    {

        for (int i=desde; i<=hasta; i++)

        {

            if(esPrimo(i))

            {
                lock.lock();
                r.sumar(i);
                lock.unlock();
            }

        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }



    private boolean esPrimo(int n)

    {

        int raiz = (int) Math.sqrt((double) n);

        boolean primo = true;

        int i=2;

        while(primo && i<=raiz)

        {

            if (n % i == 0)

                primo=false;

            i++;

        }

        return primo;

    }

}
