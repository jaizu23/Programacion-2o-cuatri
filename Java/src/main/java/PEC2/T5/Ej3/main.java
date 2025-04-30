package main.java.PEC2.T5.Ej3;

public class main {
    public static void main(String[] args) {
        PistaTenis pista = new PistaTenis();
        for (int i = 0; i < 12; i++) {
            Tenista tenista = new Tenista(i, pista  );
            tenista.start();
        }
    }
}
