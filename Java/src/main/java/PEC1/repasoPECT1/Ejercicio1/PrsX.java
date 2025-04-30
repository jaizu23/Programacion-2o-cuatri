
package main.java.PEC1.repasoPECT1.Ejercicio1;

/**
 * Proceso de tipo sensor (PrsX), que periódicamente (entre 1 y 2 segundos) 
 * tomarán el valor de temperatura de su sensor y lo escribirán en una estructura 
 * de datos compartida (cada PrsX tiene asociado un único espacio de la estructura).
 */
public class PrsX extends Thread
{        
    private int idSensor;
    private int temperatura;
    private SistemaDomotico sistema;
    
    public PrsX(SistemaDomotico sistema, int idSensor)
    {
        this.idSensor=idSensor;
        this.temperatura = 0;
        this.sistema=sistema;
    }
    
    public void run()
    {
        //Como el proceso no para lo insertamos en un while(true)
        while(true)
        {
            try
            {
                //Obtener la temperatuda (random entre 10 y 30 grados
                temperatura = sistema.getDisplay();
                temperatura = 10+(int)(20.*Math.random());
                System.out.println("Temperatura del sensor " + idSensor +":" + temperatura);
                
                //Escribir temperatura en el sistema domótico
                sistema.escribirTemperatura(temperatura, idSensor);                
                sleep(1000+(int)(1000.*Math.random()));
            }catch(InterruptedException e)
            {
                System.out.println("Sensor " + idSensor + " interrumpido");
            }
        }
    }
}
