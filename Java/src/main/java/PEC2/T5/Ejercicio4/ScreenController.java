package main.java.PEC2.T5.Ejercicio4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ScreenController  implements Initializable {

    Puente puente;
    @FXML
    private TextField txtIzquierdaADerecha;
    @FXML
    private TextField txtEnPuente;
    @FXML
    private TextField txtDerechaAIzquierda;
    @FXML
    private Label labelSentido;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Vehiculo v;
        puente = new Puente(txtIzquierdaADerecha, txtEnPuente, txtDerechaAIzquierda, labelSentido);
        for(int i=1; i<=100; i++)
        {
            v=new Vehiculo(i, puente);
            v.start();
        }
    }
}