package main.java.PEC2.T5.Ejercicio4;

import javafx.application.Platform;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ListaThreads {
    ArrayList<Thread> lista;
    TextField txtfield;

    public ListaThreads(TextField tf)
    {
        lista=new ArrayList<Thread>();
        this.txtfield =tf;
    }

    public synchronized void meter(Thread t)
    {
        lista.add(t);
        imprimir();
    }

    public synchronized void sacar(Thread t)
    {
        lista.remove(t);
        imprimir();
    }

    public void imprimir()
    {
        String contenido="";
        for(int i=0; i<lista.size(); i++)
        {
            contenido=contenido+lista.get(i).getName()+" ";
        }
        final String textoImprimir = contenido.toString();

        Platform.runLater(() -> {
            txtfield.setText(textoImprimir);
        });
    }
}
