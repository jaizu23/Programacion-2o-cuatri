/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesion1.Ej0;

import java.math.BigInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author lucas
 */
public class Resultado {
    
    private BigInteger resultado;
    private final Lock cerrojo = new ReentrantLock();
    public Resultado()
    {
        resultado=new BigInteger("0");
    }
    
    public void sumar(int i)
    {
        cerrojo.lock();
        try {
            resultado= resultado.add(new BigInteger(String.valueOf(i)));
        } finally {
            cerrojo.unlock();
        }
    }
    
    public BigInteger getSuma()
    {
        return resultado;
    }
}
