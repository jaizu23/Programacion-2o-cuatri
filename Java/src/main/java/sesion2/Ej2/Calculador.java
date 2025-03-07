package main.java.sesion2.Ej2;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculador extends Thread

{

    int desde, hasta;

    Resultado r;

    private Lock lock;

    public Calculador(int x, int y, Resultado r, Lock lock)

    {

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
