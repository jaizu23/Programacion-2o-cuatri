package main.java.sesion1.Ej9;

public class hilo extends Thread {
    private int id;

    public hilo(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Hilo #" + id);
    }
}
