
package main.java.PEC1.repasoPECT1.Ejercicio1;

/**
 * Se dispone de un sistema domótico compuesto por varios sensores de temperatura y 
 * un display que mostrará la temperatura promedia. El programa estará compuesto 
 * por los siguientes procesos:Procesos de tipo sensor (PrsX), que periódicamente 
 * (entre 1 y 2 segundos) tomarán el valor de temperatura de su sensor y lo 
 * escribirán en una estructura de datos compartida (cada PrsX tiene asociado 
 * un único espacio de la estructura).Un proceso de tipo display (PrD), que 
 * periódicamente (entre 3 y 4 segundos) calculará el valor promedio de la 
 * estructura compartida y lo mostrará en un display (consola).
 */
public class Ejercicio1 
{
    public static void main(String[] args) 
    {
        //Se instancia el elemento común
        SistemaDomotico sistema = new SistemaDomotico();
        //Se instancian y arrancan los hilos
        PrsX sensor1 = new PrsX(sistema, 1);
        sensor1.start();
        PrsX sensor2 = new PrsX(sistema, 2);
        sensor2.start();
        PrD display = new PrD(sistema);
        display.start();
    }
    
}
