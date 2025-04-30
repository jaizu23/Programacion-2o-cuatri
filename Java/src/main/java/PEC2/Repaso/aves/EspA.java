package main.java.PEC2.Repaso.aves;

public class EspA extends pajaro implements Runnable{
    private Nido nido;

    public int getid() {
        return id;
    }

    private int id;

    public EspA(Nido nido, int id){
        super(id);
        this.nido = nido;
    }

    public void run(){
        nido.
        System.out.println("EspA " + id + " ha comido");
    }
}
