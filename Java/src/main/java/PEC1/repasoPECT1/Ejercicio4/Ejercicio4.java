
package main.java.PEC1.repasoPECT1.Ejercicio4;

/** * 
 * Se desea modelar el funcionamiento de 50 trabajadores de una empresa de servicios. La rutina de los trabajadores es la siguiente:
 * 1-Al iniciar su jornada laboral ficharán en un cajetín de la entrada, el cual informará (escribiendo un mensaje por pantalla) sobre su ID, la hora de entrada y el número de trabajadores que han fichado hasta el momento (incluido el actual). Tardará 1 segundo en realizar el registro.
 * 2-Preparará un café en la máquina de café, el cual tarda en prepararse 5 segundos. Se debe mostrar un mensaje con el número total de cafés preparados.
 * 3-Acudirá a su mesa de trabajo y trabajará un tiempo aleatorio entre 20 y 30 segundos.
 * 4-Los usuarios con un ID par acudirán a por un segundo café, mostrando nuevamente el número total de cafés preparados.
 * 5-Volverá a su puesto de trabajo y trabajará un tiempo aleatorio entre 20 y 30 segundos.
 * 6-Todos los empleados finalizarán su jornada laboral fichando nuevamente en el cajetín de la entrada, el cual informará del ID y hora de salida del trabajador, así como el número de trabajadores
 */
public class Ejercicio4 
{

    public static void main(String[] args) 
    {
        //Instanciar el elemento común
        Edificio edificio = new Edificio();
        
        //Instanciar y arrancar todos los trabajadores
        for (int i = 1; i <= 50; i++) 
        {
            Trabajador trabajador = new Trabajador(i, edificio);
            trabajador.start();
        }
    }    
}
