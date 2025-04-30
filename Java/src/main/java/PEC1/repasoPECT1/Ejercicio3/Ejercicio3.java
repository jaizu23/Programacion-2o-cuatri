package main.java.PEC1.repasoPECT1.Ejercicio3;

import static java.lang.Thread.sleep;

/**
 *Se desea simular el funcionamiento de una tienda de ropa con el siguiente comportamiento:
 *Los clientes llegan de forma escalonada cada 1 o 2 segundos. 
 *Los clientes echarán un vistazo a los productos y tomarán aquellos que desean probarse de forma aleatoria, pudiendo coger de 0 a 5 prendas. 
 *Si tienen alguna prenda para probarse acudirán a uno de los 4 probadores de la tienda, tan pronto como esté alguno disponible. En este punto se imprimirá por pantalla el identificador la información del cliente, el probador al que ha accedido y el número de prendas. 
 *El cliente tarda 2 segundos en probarse cada prenda. 
 *Finalmente, en caso de que le haya gustado alguna prenda (se realizará de forma aleatoria), acudirá a la única caja disponible para pagar, tardando 1 segundo en llevar a cabo esta acción para cada prenda. Una vez ha pagado, abandonará la tienda.
 */
public class Ejercicio3 {

    public static void main(String[] args) 
    {
        //Instanciar el elemento común
        TiendaRopa tienda = new TiendaRopa();
        
        //Instanciar y arrancar todos los hilos de forma escalonada
        for (int i = 1; i <= 50; i++) 
        {
            try
            {
                Cliente cliente = new Cliente(tienda, i);
                cliente.start();
                sleep((int)(1000*Math.random() + 1000));
            }catch(InterruptedException e)
            {
                System.out.println("Error al crear los clientes");
            }
        }
    }
    
}
