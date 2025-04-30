package main.java.PEC2.Repaso.Ej1;

/**
 *
 * @author Ana Castillo
 */
class Jugador extends Thread {

    private String nombre;
    private PistaJuego pista;

    //Constructor para asignar los valores de referencia
    public Jugador(int id, PistaJuego pista) {
        this.nombre = String.valueOf(id);
        this.pista = pista;
    }

    @Override
    public void run() {
        try {
            pista.llegadaPista(this);

            if (pista.esArbitro(this)) {
                pista.asignarEquiposArbitro(this);
                System.out.println("Arranca el partido");
                // Simula duración del partido hasta el pitido final
                Thread.sleep(3000);
                System.out.println("Arbitro pita el final del partido");
                pista.finalizarPartido(this);

            } else {
                pista.elegirEquipoJugador(this);
                System.out.println("Jugador " + nombre + " esperando a que inicie el partido...");
                pista.finalizarPartido(this);
                System.out.println("Jugador " + nombre + " termina el partido.");
            }
        } catch (Exception e) {
            System.out.println("Error en los jugadores: " + e.toString());
        }
    }

    public String getNombre() {
        return nombre;
    }

}
