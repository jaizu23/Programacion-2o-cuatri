package main.java.PEC1.repasoPECT1.Examen2023.opcion1;

/**
 * Clase que representa a un estudiante 
 */
public class Estudiante extends Thread 
{
    private int idEstudiante;
    private int idioma;
    private Academia academia;
    public Estudiante(int idEstudiante, int idioma, Academia academia)
    {
        this.idEstudiante = idEstudiante;
        this.idioma = idioma;
        this.academia = academia;

    }
    
    public int getIdEstudiante()
    {
        return idEstudiante;
    }
    
    @Override
    public void run()
    {
        try {
            //1-Entra a la sala de estudio
            academia.entrarAula(this, idioma, true);
            
            //2-Estudia
            sleep(30000);
            
            //3-Sale del aula
            academia.entrarAula(this, idioma, false);
            
            //4-Toma un descanso
            int opcion = 3 + (int) (3 * Math.random());
            academia.entrarDescanso(this, opcion);
            
            //5-Entra a la sala de estudio
            academia.entrarAula(this, idioma, true);
            
            //6-Estudia
            sleep(30000);
            
            //7-Sale del aula
            academia.entrarAula(this, idioma, false);
            
        } catch (InterruptedException ex) {
            System.out.println("Error en el estudiante");
        }
    }
}
