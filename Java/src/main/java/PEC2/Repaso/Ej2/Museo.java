package main.java.PEC2.Repaso.Ej2;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Ana Castillo
 */
public class Museo {

    //Estructuras para almacenar quién está en cada parte del ejercicio
    private ArrayList<Persona> entradaEste = new ArrayList<>();
    private ArrayList<Persona> entradaOeste = new ArrayList<>();
    private ArrayList<Persona> dentroMuseo = new ArrayList<>();

    private final int capacidadDisponible = 20;
    private int alternancia = 0; // Indicará de dónde viene la última persona 0-Este, 1-Oeste

    //Cerrojo y 2 condiciones, una para bloquear la entrada este y otra la entrada oeste
    Lock lock = new ReentrantLock();
    Condition oeste = lock.newCondition();
    Condition este = lock.newCondition();

    // Método para entrar por el este
    public void entrar_museo_este(Persona persona) {
        lock.lock();
        try {
            entradaEste.add(persona);
            while (dentroMuseo.size() == capacidadDisponible) {
                este.await();
            }
            entradaEste.remove(persona);
            dentroMuseo.add(persona);
            System.out.println("Persona " + persona.getIdPersona() + " entrando por ESTE. Ocupacion: " + dentroMuseo.size() + " Colas: " + entradaEste.size() + ";" + entradaOeste.size());

        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    // Método para entrar por el oeste
    public void entrar_museo_oeste(Persona persona) {
        lock.lock();
        try {
            entradaOeste.add(persona);
            while (dentroMuseo.size() == capacidadDisponible) {
                oeste.await();
            }
            entradaOeste.remove(persona);
            dentroMuseo.add(persona);
            System.out.println("Persona " + persona.getIdPersona() + " entrando por OESTE. Ocupacion: " + dentroMuseo.size() + " Colas: " + entradaEste.size() + ";" + entradaOeste.size());

        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    //Método para salir del museo
    public void salir_museo(Persona persona) {
        lock.lock();
        try {
            dentroMuseo.remove(persona);
            System.out.println("Persona " + persona.getIdPersona() + " SALIENDO. Ocupacion: " + dentroMuseo.size() + " Colas: " + entradaEste.size() + ";" + entradaOeste.size());
            if (entradaEste.size() > 0 && entradaOeste.size() > 0) {
                //personas esperando en las dos entradas (alternancia)
                if (alternancia == 0) {
                    oeste.signal();
                    alternancia = 1;
                } else {
                    este.signal();
                    alternancia = 0;
                }
            } else {
                if (entradaEste.size() > 0) {
                    este.signal();
                } else if (entradaOeste.size() > 0) {
                    oeste.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
