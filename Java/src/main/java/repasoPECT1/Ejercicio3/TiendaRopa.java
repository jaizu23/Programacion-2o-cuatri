package main.java.repasoPECT1.Ejercicio3;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Tienda de ropa compuesta por 4 probadores y 1 caja
 */
public class TiendaRopa {

    private Lock cerrojoProbadores;
    private Lock cerrojoCaja;
    private ArrayList<Boolean> probadoreslibres;

    public TiendaRopa() {
        cerrojoProbadores = new ReentrantLock();
        cerrojoCaja = new ReentrantLock();
        probadoreslibres = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            probadoreslibres.add(true);
        }
    }

    public int entrarProbador(int idCliente, int numPrendas) {
        //Hacemos que los hilos pasen de uno en uno a los probadores
        cerrojoProbadores.lock();
        int probadorselecionado = 0;
        try {
            //Buscar el primer probador que quede libre
            while (probadorselecionado == 0) {
                for (int i = 0; i < probadoreslibres.size(); i++) {
                    if (probadoreslibres.get(i)) {
                        probadoreslibres.set(i, false);
                        probadorselecionado = i;
                        i = probadoreslibres.size(); //Para romper el for sin necesidad de un break
                        
                        System.out.println("Probador " + probadorselecionado + 
                                ": Cliente: " + idCliente
                                + ". Num prendas: " + numPrendas);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al entrar a los probadores: " + e.toString());
        } finally {
            cerrojoProbadores.unlock();
        }
        return probadorselecionado;
    }

    void salirProbador(int idCliente, int probador) 
    {
        System.out.println("Probador " + probador + " libre");
        probadoreslibres.set(probador, true);
    }

    void pagar(int idCliente, int prendas) 
    {
        cerrojoCaja.lock();
        try
        {
            System.out.println("El cliente " + idCliente + " pasa por caja a pagar " + prendas + " prendas");
            sleep(1000 * prendas);
        }catch(InterruptedException e)
        {
            System.out.println("Error al pagar en caja");
        }
        finally
        {
            cerrojoCaja.unlock();
        }
        
    }

}
