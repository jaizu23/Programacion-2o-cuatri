package main.java.PEC2.T5.Ejercicio1;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ListaThreads {
    ArrayList<Visitante> lista;
    TextArea txtarea;

    public ListaThreads(TextArea tf)
    {
        lista=new ArrayList<Visitante>();
        this.txtarea =tf;
    }

    public synchronized void meter(Visitante t)
    {
        lista.add(t);
        imprimir();
    }

    public synchronized void sacar(Visitante t)
    {
        lista.remove(t);
        imprimir();
    }

    public void imprimir()
    {
        String contenido="";
        for(int i=0; i<lista.size(); i++)
        {
            contenido=contenido+lista.get(i).getMiId()+" ";
        }
        final String textoImprimir = contenido.toString();

        Platform.runLater(() -> {
            txtarea.setText(textoImprimir);
        });
    }
}
