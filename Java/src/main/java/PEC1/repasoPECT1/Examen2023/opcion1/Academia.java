package main.java.PEC1.repasoPECT1.Examen2023.opcion1;

/**
 * Clase que representa el objeto común a todos los hilos. Estará commpuesto por 
 * salas que tienen el mismo comportamiento, por lo que se puede utilizar un tipo
 * de datos común en todos ellos
 */
public class Academia 
{
    private Sala aula1, aula2, banio, maquinaexp, maquinacafe;
    
    public Academia()
    {
        this.aula1 = new Sala(1);
        this.aula2 = new Sala(2);
        this.banio = new Sala(3);
        this.maquinaexp = new Sala(4);
        this.maquinacafe = new Sala(5);
    }
    
    public void entrarAula(Estudiante estudiante, int idioma, boolean entrada)
    {
        switch (idioma) {
            case 1 -> aula1.entrarSala(estudiante, entrada);
            case 2 -> aula2.entrarSala(estudiante, entrada);
            default -> System.out.println("El idoma no corresponde con ningun aula");
        }
    }
    
    public void entrarDescanso(Estudiante estudiante, int opcion)
    {
        switch (opcion) {
            case 3 -> banio.entrarSala(estudiante, true);
            case 4 -> maquinaexp.entrarSala(estudiante, true);
            case 5 -> maquinacafe.entrarSala(estudiante, true);
            default -> System.out.println("La selección no corresponde a ninguna opción");
        }
    }
}
