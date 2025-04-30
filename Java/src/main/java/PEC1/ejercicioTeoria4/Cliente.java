/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.PEC1.ejercicioTeoria4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class Cliente extends Thread{
    private static int idGlobal = 0;
    private final int id;
    private final Tienda tienda;
    
    public Cliente(Tienda tienda){
        this.tienda = tienda;
        this.id = ++idGlobal;
    }
    
    @Override
    public void run(){
        int prendas = (int)(Math.random()* 6);
        System.out.println("Cliente "+id+" entra a la tienda.");
        System.out.println("El cliente "+id+" quiere probarse "+prendas+" prendas.");
        
        if (prendas > 0){
            try {
                tienda.entrarAProbador(id, prendas);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        int prendasParaPagar = 0;
        for (int i = 0; i<prendas; i++){
            if (Math.random() > 0.5){
                prendasParaPagar++;
            }
        }
        
        if (prendasParaPagar > 0){
            try {
                tienda.acudirACaja(id, prendasParaPagar);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    System.out.println("El cliente "+id+" abandona satisfecho la tienda.");
    }
}
