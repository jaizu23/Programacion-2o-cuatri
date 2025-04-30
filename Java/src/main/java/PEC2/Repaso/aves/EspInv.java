package main.java.PEC2.Repaso.aves;

public class EspInv extends pajaro implements Runnable{
    private Nido nido;


    public EspInv(Nido nido, int id){
        super(id);
        this.nido = nido;
    }
}
