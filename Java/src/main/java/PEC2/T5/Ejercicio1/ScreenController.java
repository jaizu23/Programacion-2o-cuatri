package main.java.PEC2.T5.Ejercicio1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ScreenController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TextArea txtfuera;
    @FXML
    private TextArea txtdentro;
    Exposicion exposicion;
    Visitante v;

    @FXML
    protected void detenerClick() {
        System.out.println("Detener");
    }
    @FXML
    protected void reanudarClick() {
        System.out.println("Reanudar");
    }
    @FXML
    protected void abrirClick() {
        System.out.println("Abrir");
    }
    @FXML
    protected void cerrarClick() {
        System.out.println("Cerrar");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exposicion=new Exposicion(10,txtfuera,txtdentro);
        for(int i=1; i<=60; i++)
        {
            v=new Visitante(i,exposicion);
            v.start();
        }
    }
}