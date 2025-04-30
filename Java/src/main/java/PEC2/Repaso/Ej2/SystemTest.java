package main.java.PEC2.Repaso.Ej2;

/**
 * Ejercicio Examen 2016-2017
 *
 * Un museo de obras de arte con capacidad máxima de 20 personas tiene una
 * salida y entradas (Este y Oeste). Las personas pueden entrar si hay plazas
 * libres. Si está lleno, no podrá entrar una persona hasta que otra haya
 * salido. En este caso, si hay personas esperando en las dos entradas, hay que
 * alternar la entrada seleccionada (es decir, una vez entrará una persona del
 * Este y la siguiente vez una del Oeste).
 *
 * Se debe desarrollar un programa completo que simule este funcionamiento,
 * utilizando una clase compartida que implemente este protocolo de gestión. En
 * la clase compartida deben existir al menos las siguientes tres operaciones:
 * -“entrar_museo_este”, “entrar_museo_oeste”: los procesos llaman a esta
 * operación cuando quieren entrar por la entrada Este u Oeste, respectivamente.
 * Cuando el museo está lleno, los procesos se deben quedar bloqueados hasta que
 * se les permita entrar. -“salir_museo”: los procesos llaman a esta operación
 * cuando quieren salir del museo.
 *
 * Resolver este problema utilizando únicamente cerrojos (y sus variantes)
 *
 * @author Ana Castillo
 */
public class SystemTest {

    public static void main(String arg[]) {
        //Crear el elemento común
        Museo museo = new Museo();
        //Crear y arrancar todas las personas
        for (int i = 0; i < 100; i++) {
            new Persona(i, museo).start();
        }
    }
}
