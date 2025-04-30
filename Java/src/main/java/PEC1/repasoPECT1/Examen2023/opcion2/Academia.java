package main.java.PEC1.repasoPECT1.Examen2023.opcion2;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase que representa el objeto común a todos los hilos. Estará commpuesto por 
 * salas que tienen el mismo comportamiento, por lo que se puede utilizar un tipo
 * de datos común en todos ellos
 */
public class Academia 
{
    private ArrayList<Lock> aulas;
    private ArrayList<Integer> contadorAula;
    private ArrayList<Lock> descanso;
    private ArrayList<Integer> contadorMaquina;
    
    public Academia()
    {
        //Inicializar cerrojos aulas
        aulas = new ArrayList<>();
        aulas.add(new ReentrantLock());
        aulas.add(new ReentrantLock());
        //Inicializar cerrojos máquinas
        descanso = new ArrayList<>();
        descanso.add(new ReentrantLock());
        descanso.add(new ReentrantLock());
        descanso.add(new ReentrantLock());
        
        //Contadores
        contadorAula = new ArrayList<>();
        contadorAula.add(0);
        contadorAula.add(0);
        contadorMaquina = new ArrayList<>();
        contadorMaquina.add(0);
        contadorMaquina.add(0);
    }
    
    public void entrarAula(Estudiante estudiante, int idioma, boolean entrada)
    {
        //Abrimos sólo el cerrojo que nos interese
        aulas.get(idioma).lock();
        try
        {            
            sleep(1000);
            if(entrada)
            {
                contadorAula.set(idioma, contadorAula.get(idioma) + 1);
            }else
            {
                contadorAula.set(idioma, contadorAula.get(idioma) - 1);
            }
            System.out.println("Aula " + idioma +": Estudiante " + estudiante.getIdEstudiante() 
                    + ". Fecha: " + new Date()
                    + ". Num Alumnos: " + contadorAula.get(idioma));
        }catch(InterruptedException e)
        {
            System.out.println("Error al entrar en el aula " + idioma);
        }
        finally
        {            
            //Cerramos sólo el cerrojo que nos interese            
            aulas.get(idioma).unlock(); 
        }
    }
    
    public void entrarDescanso(Estudiante estudiante, int opcion)
    {
        //Abrimos sólo el cerrojo que nos interese
        descanso.get(opcion).lock();
        try
        {            
            switch (opcion) 
            {
                case 0 -> {
                    //Máquina expendedora
                    contadorMaquina.set(opcion, contadorMaquina.get(opcion) + 1);
                    System.out.println("El estudiante " + estudiante.getIdEstudiante()
                            + " usa la máquina expendedora. Num usos: " + contadorMaquina.get(opcion));
                    sleep(5000); 
                }
                case 1 -> {
                    //Máquina cafe
                    contadorMaquina.set(opcion, contadorMaquina.get(opcion) + 1);
                    System.out.println("El estudiante " + estudiante.getIdEstudiante()
                            + " usa la máquina de café. Num usos: " + contadorMaquina.get(opcion));
                    sleep(5000); 
                }
                default -> {
                    //baño
                    System.out.println("El estudiante " + estudiante.getIdEstudiante() 
                                + " usa el baño");
                    sleep(3000); 
                }
            }    
        }catch(InterruptedException e)
        {
            System.out.println("Error al entrar en la opcion " + opcion);
        }
        finally
        {            
            //Cerramos sólo el cerrojo que nos interese            
            descanso.get(opcion).unlock(); 
        }
    }
}
