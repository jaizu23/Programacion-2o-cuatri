package main.java.repasoPECT1.Ejercicio1;

/**
 * Un proceso de tipo display (PrD), que periódicamente (entre 3 y 4 segundos) 
 * calculará el valor promedio de la estructura compartida y lo mostrará en un 
 * display (consola).
 */
public class PrD extends Thread
{
    private int temperatura;
    private SistemaDomotico sistema;
    
    public PrD(SistemaDomotico sistema)
    {
        this.temperatura = 0;
        this.sistema=sistema;
    }
    
    @Override
    public void run()
    {
        //Como el proceso no para lo insertamos en un while(true)
        while(true)
        {
            try
            {
                temperatura = sistema.getDisplay();
                System.out.println("Temperatura media: " + temperatura);
                sleep(3000+(int)(1000.*Math.random()));
            }catch(InterruptedException e)
            {
                System.out.println("El display ha sido interrumpido");
            }
        }
    }
}
