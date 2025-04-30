/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.PEC1.ejercicioTeoria4;

import static java.lang.Thread.sleep;

/**
 *
 * @author lucas
 */
public class SimulacionTienda {
    public static void main(String[] args) throws InterruptedException {
        Tienda tienda = new Tienda();
        int totalClientes = 10;
        
        for (int i = 0; i < totalClientes; i++) {
            Cliente cliente = new Cliente(tienda);
            cliente.start();
            sleep((int)(Math.random() * 1000) + 1000);
        }
    }
}
