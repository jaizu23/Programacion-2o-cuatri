package main.java.PEC2.Repaso.Ej1;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;

/**
 *
 * @author Ana Castillo
 */
public class PistaJuego {

    //CyclicBarrier de tamaño 11 para que lleguen todos los niños (10 jugadores + árbitro)
    private CyclicBarrier barrera = new CyclicBarrier(11);
    //CountDownLatch para que todos esperen al pitido final del árbitro
    private CountDownLatch finPartido = new CountDownLatch(1);
    //Exchanger para intercambiar información entre árbitro y jugadores
    private Exchanger<String> exchanger = new Exchanger<>();
    //Lista de jugadores para que el árbitro sepa quién es quién
    private ArrayList<Thread> jugadores = new ArrayList<>();
    //Contadores de jugadores de cada equipo y el id del árbitro que será aleatorio
    private int nunEquipo1, numEquipo2;
    private String idArbitro;

    //Constructor para asignar los valores de referencia
    public PistaJuego() {
        barrera = new CyclicBarrier(11);
        finPartido = new CountDownLatch(1);
        exchanger = new Exchanger<>();
        jugadores = new ArrayList<>();
        nunEquipo1 = 0;
        numEquipo2 = 0;
        idArbitro = "";
    }

    //Comprobar si es el designado como árbitro
    public boolean esArbitro(Jugador n) {
        boolean arbitro = false;
        if (idArbitro.equals("")) {
            idArbitro = n.getNombre();
            arbitro = true;
            System.out.println("Jugador " + n.getNombre() + " te toca ser arbitro");
        } else {
            if (idArbitro.equals(n.getNombre())) {
                arbitro = true;
            } else {
                arbitro = false;
            }
        }
        return arbitro;
    }

    //Llegada de todos los niños a la pista. Deberán esperar a que estén todos
    public void llegadaPista(Jugador n) {
        try {
            System.out.println("Jugador " + n.getNombre() + " ha llegado a la pista");
            jugadores.add(n);
            // Espera a que lleguen los 11 niños
            barrera.await();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException en la barrera: " + ex.toString());
        } catch (BrokenBarrierException ex) {
            System.out.println("BrokenBarrierException en la barrera: " + ex.toString());
        }
    }

    // Método que va a asignar los equipos. Sólo lo va a ejecutar el árbitro. 
    public void asignarEquiposArbitro(Jugador n) {
        for (int i = 1; i < jugadores.size(); i++) {
            try {
                // Espera el mensaje del jugador
                String mensaje = exchanger.exchange(null);
                System.out.println("Arbitro recibe: " + mensaje);
                //Decidir con qué equipo va
                String equipo;
                if (nunEquipo1 >= 5) {
                    equipo = "2";
                } else {
                    if (numEquipo2 >= 5) {
                        equipo = "1";
                    } else {
                        equipo = String.valueOf((int) (Math.random() * 2) + 1);
                    }
                }
                exchanger.exchange(equipo); // Responder con el rol
            } catch (InterruptedException ex) {
                System.out.println("Error al asignar un equipo por el arbitro: " + ex.toString());
            }
        }
    }

    // Método para elegir equipo. Se ejecutará por los jugadores. Usamos un monitor para que elijan de 1 en 1
    public synchronized String elegirEquipoJugador(Jugador n) {
        String equipo = "";
        try {
            //El jugador se ofrece a formar equipo
            exchanger.exchange("Soy el jugador " + n.getNombre() + ", con que equipo voy?");
            //Espera la respuesta del árbitro
            equipo = exchanger.exchange(""); // segundo intercambio: recibe equipo
            System.out.println("Jugador " + n.getNombre() + " ha sido asignado al " + equipo);
        } catch (InterruptedException ex) {
            System.out.println("Error al elegir un equipo el jugador: " + ex.toString());
        }
        return equipo;
    }

    //Método para finalizar el partido
    public void finalizarPartido(Jugador n) {
        try {

            if (esArbitro(n)) {
                finPartido.countDown(); // Señala el fin del partido para sincronizar a los jugadores
            } else {
                finPartido.await(); // Esperar a que el árbitro pite el final
            }
        } catch (InterruptedException ex) {
            System.out.println("Error al esperar el fin del partido: " + ex.toString());
        }
    }
}
