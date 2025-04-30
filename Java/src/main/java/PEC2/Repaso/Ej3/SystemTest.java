package main.java.PEC2.Repaso.Ej3;

/**
 * Ejercicio Examen 2016-2017 
 *
 * Se desea modelar el comportamiento de un conjunto de coches que van a hacer
 * una carrera y los coches de seguridad (safety-car) que, además, son los
 * responsables de la seguridad en la carrera.
 *
 * Se cuenta con 20 coches de carreras y 2 coches de seguridad. Todos ellos van
 * llegando al circuito de forma escalonada y en cualquier orden (tiempo
 * aleatorio entre 4-16s). Una vez reunidos los 22 coches en el circuito se pasa
 * a la fase de revisión del circuito. Los 2 coches de seguridad inician una
 * vuelta de revisión del circuito para comprobar que todo está en orden (tardan
 * de 20s a 30s) mientras los 20 coches de carreras esperan a que terminen.
 *
 * A continuación comienzan la carrera los 20 coches de carreras (duración
 * 120s). Los 2 coches de seguridad esperan a que todos los corredores terminen
 * y los 2 coches de seguridad finalizan entonces con un mensaje indicando el
 * final de la carrera. Se mostrará en pantalla cada cambio de estado,
 * incluyendo la finalización de cada estado y el comienzo del siguiente.
 *
 * El programa se deberá modelar sin utilizar monitores, semáforos ni cerrojos.
 *
 * @author Ana Castillo
 */
public class SystemTest {

    public static void main(String arg[]) {
        Circuito circuito = new Circuito();
        for (int i = 0; i < 2; i++) {
            new SafetyCar(i, circuito).start();
        }

        for (int i = 0; i < 20; i++) {
            new RaceCar(i, circuito).start();
        }

    }
}
