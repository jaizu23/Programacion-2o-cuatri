package main.java.PEC2.Repaso.Ej5;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejercicio Examen 2015/2016
 *
 * Una compañía de producción de prendas de vestir desea simular el proceso de
 * doblado y empaquetado de prendas.
 *
 * En este sistema se distinguen dos tipos de tareas: doblar cada prenda que
 * llega y empaquetar prendas cuando 5 del mismo tipo estén dobladas.
 *
 * Se consideran 5 tipos de prendas: camisa, pantalón, camiseta, falda y
 * chaqueta.
 *
 * El sistema dispone de 5 trabajadores para la tarea de doblado, pero si no hay
 * tareas, hasta 4 de ellos podrían pasar a otros trabajos, quedando solo 1 a la
 * espera. Para la tarea de empaquetado se dispone de 3 trabajadores que si no
 * hay tareas bajará hasta 1 que queda a la espera.
 *
 * El sistema no necesita llevar un control individual de cada prenda, sólo
 * conocer el número de las que están pendientes o de las que se han doblado de
 * cada tipo o la cantidad de paquetes de cada tipo que hay en el sistema.
 *
 * Crear el sistema con 200 prendas de prueba que "llegan" con una frecuencia
 * aleatoria.
 *
 * Se emitirán mensajes por pantalla informando del estado del sistema cada vez
 * que se produzca un cambio significativo en el mismo.
 *
 * @author Ana Castillo
 */
public class SystemTest {

    public static void main(String arg[]) {
        //Crear los pools cada uno del tipo que corresponda
        ExecutorService exDoblado = Executors.newFixedThreadPool(5);
        ExecutorService exEmpaquetado = Executors.newFixedThreadPool(3);

        ArrayList<Integer> numDoblados = new ArrayList<>();
        numDoblados.add(0);
        numDoblados.add(0);
        numDoblados.add(0);
        numDoblados.add(0);
        numDoblados.add(0);

        //Almacenar los resultados de las tareas de doblado
        ArrayList<Future<Prenda>> arrayOutputDoblado = new ArrayList<>();

        //Mandar todas las prendas a doblar y almacenar sus resultados
        for (int i = 0; i < 100; i++) {
            Prenda prenda = new Prenda();
            Future<Prenda> outputDoblado = exDoblado.submit(new TareaDoblado(i, prenda));
            arrayOutputDoblado.add(outputDoblado);
        }

        //Comprobar las prendas dobladas y empaquetarlas
        for (int i = 0; i < 100; i++) {
            try {
                Future<Prenda> prendaDoblada = arrayOutputDoblado.get(i);
                if (prendaDoblada.get().getDoblada()) {
                    //Actualizar el número de prendas dobladas del tipo                    
                    numDoblados.set(prendaDoblada.get().getTipoPrenda(), numDoblados.get(prendaDoblada.get().getTipoPrenda()) + 1);
                    //Comprobar que se pueden empaquetar
                    if (numDoblados.get(prendaDoblada.get().getTipoPrenda()) == 5) {
                        exEmpaquetado.execute(new TareaEmpaquetado(prendaDoblada.get().getTipoString()));
                        numDoblados.set(prendaDoblada.get().getTipoPrenda(), numDoblados.get(prendaDoblada.get().getTipoPrenda()) - 5);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al generar la tarea de empaquetado: " + e.toString());
            }

        }
        exDoblado.shutdown();
        exEmpaquetado.shutdown();
    }

}
