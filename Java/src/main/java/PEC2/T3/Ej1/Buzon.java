package main.java.PEC2.T3.Ej1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buzon {

    private String mensaje;

    private boolean hayMensaje = false;

    private Lock lock = new ReentrantLock();
    private Condition lleno = lock.newCondition();

    public void enviaMensaje(String msg) {
        lock.lock();
        try {
            while (hayMensaje) {
                try {
                    lleno.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            hayMensaje = true;
            lleno.signalAll();
            mensaje = msg;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


    public String recibeMensaje() {
        lock.lock();
        try {
            while (!hayMensaje) try {
                lleno.await();
            } catch (InterruptedException e) {
            }
            hayMensaje = false;
            lleno.signalAll();
            return mensaje;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }
    }

}