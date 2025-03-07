package main.java.repasoPECT1.Ejercicio4;

public class Trabajador extends Thread
{
    private int idTrabajador;
    private Edificio edificio;
    
    public Trabajador(int idTrabajador, Edificio edificio)
    {
        this.idTrabajador=idTrabajador;
        this.edificio = edificio;        
    }
    
    @Override
    public void run()
    {
        try
        {
            //1-Fichar la entrada
            edificio.fichar(this, true); 

            //2-Café
            edificio.cafe(this); 

            //3-Trabajar
            sleep(20000 + (int)(Math.random() * 10000));

            //si es par
            if(idTrabajador%2==0)
            {
                //4-Espera máquna de café
                edificio.cafe(this); 
            }
            //5-Trabajar 
            sleep(20000 + (int)(Math.random() * 10000));

            //6-Fichar la salida
            edificio.fichar(this, false); 
        }catch(InterruptedException e)
        {
            System.out.println("El trabajador " + idTrabajador + "ha dado error: " + e);
        }
    }
    
    public int getIdTrabajador()
    {
        return idTrabajador;
    }
}
