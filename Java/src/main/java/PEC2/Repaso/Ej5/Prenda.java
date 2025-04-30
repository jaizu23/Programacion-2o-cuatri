package main.java.PEC2.Repaso.Ej5;

/**
 *
 * @author Ana Castillo
 */
public class Prenda 
{
    private String[] tiposPrenda= {"camisa", "pantalon","camiseta","falda","chaqueta"};
    private String tipoString;
    private int tipoPrenda;
    private Boolean doblada;
    
    public Prenda()
    {
        tipoPrenda = (int)(Math.random()*4);
        tipoString = tiposPrenda[tipoPrenda];
        doblada = false;
    }

    public String getTipoString() {
        return tipoString;
    }

    public void setTipoString(String tipoString) {
        this.tipoString = tipoString;
    }

    public int getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(int tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public Boolean getDoblada() {
        return doblada;
    }

    public void setDoblada(Boolean doblada) {
        this.doblada = doblada;
    }    
}
