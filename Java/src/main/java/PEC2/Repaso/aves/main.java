package main.java.PEC2.Repaso.aves;

public class main {
    public static void main(String[] args) {
        int espa = 0;
        int espinv = 0;

        Nido nido = new Nido();
        for (int i = 0; i < 200; i++) {
            if (espa + espinv == 100 ){
                Aguila a = new Aguila(nido);
            }
            if (espa < 100 & espinv < 100) {
                if (Math.random() < 0.5) {
                    EspA p = new EspA(nido, espa);
                    espa++;
                } else {
                    EspInv p = new EspInv(nido, espinv);
                    espinv++;
                }
            } else {
                if (espa >= 100) {
                    EspInv p = new EspInv(nido, espinv);
                    espinv++;
                } else {
                    EspA p = new EspA(nido, espa);
                    espa++;
                }
            }
        }
    }
}
