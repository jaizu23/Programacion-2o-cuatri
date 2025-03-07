package main.java.repasoPECT1.Ejercicio5.intento;

public class Main {
    public static void main(String[] args) {
        Columpio col = new Columpio();

        for (int i=0; i<20; i++) {
            Ninnio n = new Ninnio(col, i);
            n.start();
        }
    }
}
