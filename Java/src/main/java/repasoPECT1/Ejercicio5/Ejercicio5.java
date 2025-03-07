package main.java.repasoPECT1.Ejercicio5;

/**
 * En un parque hay un columpio que solo un niño puede utilizar cada vez. 
 * Hay 20 niños en el parque que realizan 30 veces una secuencia de acciones en 
 * la que primero juegan de 1 a 20 segundos y luego intentan montar en el 
 * columpio. Para montar en el columpio hay una única cola donde los niños 
 * esperan entre 5 o 10 segundos como máximo, en el caso de no poder acceder al 
 * columpio. En el caso de no poder, desisten y se da por completado el ciclo. 
 * Si un niño accede al columpio, monta durante 3 segundos.
 */
public class Ejercicio5 {

    public static void main(String[] args) 
    {
        //Instanciar elemento común
        Parque parque = new Parque();
        
        //Instanciar y arrancar a todos los niños
        for (int i = 1; i <= 20; i++) 
        {
            Ninio n = new Ninio(i, parque);
            n.start();
        }
    }
    
}
