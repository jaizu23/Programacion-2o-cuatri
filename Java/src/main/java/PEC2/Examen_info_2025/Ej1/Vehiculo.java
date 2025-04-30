package main.java.PEC2.Examen_info_2025.Ej1;

public class Vehiculo extends Thread{
    private Estacion estacion;
    private int id;
    public Vehiculo (int id, Estacion estacion) {
        this.id = id;
        this.estacion = estacion;
    }

    @Override
    public void run () {
        estacion.entrar();
        estacion.repostar();
        estacion.pagar();
        estacion.salir();
    }

    public int getid() {
        return id;
    }
}
