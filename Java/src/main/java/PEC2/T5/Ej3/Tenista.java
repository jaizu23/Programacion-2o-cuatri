package main.java.PEC2.T5.Ej3;

public class Tenista extends Thread{
    public int getid() {
        return id;
    }

    private int id;

    private PistaTenis pista;

    public Tenista(int id, PistaTenis pista){
        this.id = id;
        this.pista = pista;
    }

    public void run(){
        pista.jugar(this);
    }
}
