package main.java.PEC2.T3.Ej1;

public class PruebaBuzon1 {

    public static void main(String[] s) {

        Buzon buzonX = new Buzon();

        Productor pedro = new Productor("Pedro ", 5, buzonX);

        Productor juan = new Productor("Juan ", 4, buzonX);

        Productor antonio = new Productor("Antonio ", 6, buzonX);

        Productor luis = new Productor("Luis ", 7, buzonX);

        Consumidor jose = new Consumidor(22, buzonX);

        pedro.start();

        juan.start();

        antonio.start();

        luis.start();

        jose.start();

    }

}

