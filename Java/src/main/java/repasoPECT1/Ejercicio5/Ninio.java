package main.java.repasoPECT1.Ejercicio5;

public class Ninio extends Thread {

    private Parque parque;
    private int idNinio;

    public Ninio(int idNinio, Parque parque) {
        this.idNinio = idNinio;
        this.parque = parque;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                //Juega entre 1 y 20 segundos
                System.out.println("Ninio" + idNinio + " empieza a jugar");
                int tiempojuego = 1000 + (int) (Math.random() * 19000);
                sleep(tiempojuego);
                //Intenta tomar el columpio
                System.out.println("Ninio" + idNinio + " va al columpio");
                parque.entrarColumpio(idNinio);
            } catch (InterruptedException e) {
                System.out.println("Error en el Ninio " + idNinio);
            }
        }
    }
}
