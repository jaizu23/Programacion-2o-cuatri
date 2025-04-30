package main.java.PEC2.Repaso.Ej1;

import static java.lang.Thread.sleep;

/**
 * Se desea modelar el comportamiento de un conjunto de coches que van a hacer
 * una carrera y los coches de seguridad (safety car) que, además, son los
 * responsables de la seguridad en la carrera Se cuenta con 20 coches de
 * carreras y 2 coches de seguridad Todos ellos van llegando al circuito de
 * forma escalonada y en cualquier orden (tiempo aleatorio entre 4 16 s) Una vez
 * reunidos los 22 coches en el circuito se pasa a la fase de revisión del
 * circuito Los 2 coches de seguridad inician una vuelta de revisión del
 * circuito para comprobar que todo está en orden (tardan de 20 s a 30 s)
 * mientras los 20 coches de carreras esperan a que terminen A continuación
 * comienzan la carrera los 20 coches de carreras (duración 120 s) Los 2 coches
 * de seguridad esperan a que todos los corredores terminen y los 2 coches de
 * seguridad finalizan entonces con un mensaje indicando el final de la carrera
 * Se mostrará en pantalla cada cambio de estado, incluyendo la finalización de
 * cada estado y el comienzo del siguiente
 *
 * @author Ana Castillo
 */
public class SystemTest {

    public static void main(String[] args) {
        //Crear el elemento común para poder usarlo para sincronizar a los hilos
        PistaJuego pista = new PistaJuego();
        //Crear a los 11 niños y asignarles un id único y el elemento común
        for (int i = 0; i < 11; i++) {
            try {
                Jugador nino = new Jugador(i, pista);
                nino.start();
                sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Error al arrancar los hilos: " + ex.toString());
            }
        }
    }
}
