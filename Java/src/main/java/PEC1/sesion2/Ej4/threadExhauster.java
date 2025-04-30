package main.java.PEC1.sesion2.Ej4;

public class threadExhauster{
    public static void main(String[] args) {
        int i = 0;
        while (true){
            hilo h = new hilo(i);
            h.start();
            i++;
        }
    }
}
