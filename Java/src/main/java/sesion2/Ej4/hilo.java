package main.java.sesion2.Ej4;

public class hilo extends Thread {
    private int id;
    public hilo(int id) {
        this.id = id;
    }
    public void run() {
        System.out.println("hilo: #" + id);
        while (true) {}
    }
}
