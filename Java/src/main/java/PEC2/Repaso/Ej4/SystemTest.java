package main.java.PEC2.Repaso.Ej4;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio Examen 2015/2016
 *
 * Se desea modelar el comportamiento de un grupo de jugadores de fútbol que
 * tienen un partido concertado y los árbitros que, además, son los responsables
 * de las instalaciones.
 *
 * Se cuenta con 22 jugadores que van llegando de forma escalonada (tiempo
 * aleatorio entre 5-20s) y los 5 árbitros que, desde el principio están en las
 * instalaciones, esperando a que todos lleguen. Una vez reunidos los 22
 * jugadores deben esperar a que los 5 árbitros se preparen (tardan de 2s a 7s).
 *
 * A continuación comienza el partido, donde los 22 jugadores se ponen en marcha
 * (transcurren 90s).
 *
 * Los árbitros esperan a que todos los jugadores terminen y los 5 árbitros
 * finalizan con un mensaje indicando el final del partido.
 *
 * Se mostrará en pantalla cada cambio de estado, incluyendo la finalización de
 * cada estado y el comienzo del siguiente.
 *
 * @author Ana Castillo
 */
public class SystemTest {

    public static void main(String arg[]) {
        ExecutorService exFundicion = Executors.newFixedThreadPool(7);
        ExecutorService exForjado = Executors.newFixedThreadPool(5);

        ArrayList<Future<Boolean>> arrayOutputFundicion = new ArrayList<>();

        int partialFundicion = 0;
        int idTaskForjado = 0;
        ArrayList<Integer> listIdFundicion = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            Future<Boolean> outputFundicion = exFundicion.submit(new TareaFundicion(i));
            arrayOutputFundicion.add(outputFundicion);
        }

        for (int i = 0; i < 500; i++) {
            Future<Boolean> outputFundicion = arrayOutputFundicion.get(i);
            try {
                if (outputFundicion.get())//blocking
                {
                    partialFundicion++;
                    listIdFundicion.add(i);
                    if (partialFundicion == 9) {
                        partialFundicion = 0;//reinit
                        //submit a forjado task
                        exForjado.execute(new TareaForjado(idTaskForjado, (ArrayList<Integer>) listIdFundicion.clone()));
                        idTaskForjado++;
                        listIdFundicion.clear();//reinit
                    }
                }
            } catch (InterruptedException | ExecutionException ex) {
                System.out.println("Exception en la ejecución del programa:" + ex.toString());
            }
        }
        exFundicion.shutdown();
        exForjado.shutdown();
    }

}
