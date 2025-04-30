/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.PEC1.ejercicioTeoria4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author lucas
 */
public class Tienda {
    private final Lock lockProbadores = new ReentrantLock();
    private int probadoresLibres = 4;
    private final Lock lockProbadoresLibres = new ReentrantLock();
    private final Lock lockCaja = new ReentrantLock();
    private boolean cajaLibre = true;
    
    public void entrarAProbador(int id, int prendas) throws InterruptedException {
        
    }
    
    public void acudirACaja(int id, int prendasParaPagar) throws InterruptedException {
        lockCaja.lock();
        try {
            while (!cajaLibre) {
            
            }
            cajaLibre = false;
            System.out.println("Cliente "+id+" acude a caja a pagar "+prendasParaPagar+" prendas.");
        } finally {
            lockCaja.unlock();
        }
        Thread.sleep(prendasParaPagar * 1000);
        lockCaja.lock();
        try {
            cajaLibre = true;
            System.out.println("¡Siguienteee!");
        }finally {
            lockCaja.unlock();
        }
    }
}
