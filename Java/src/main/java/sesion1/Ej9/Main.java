package main.java.sesion1.Ej9;

public class Main {
    public static void main(String[] args) {
        for (int i=0; i < 1000; i ++) {
            hilo h = new hilo(i);
            h.start();
        }
    }
}
