package main.java.sesion2.Ej2;

import java.math.BigInteger;



public class Resultado

{

    private BigInteger suma = new BigInteger("0");



    public BigInteger getSuma()

    {

        return suma;

    }



    public void sumar(int n)

    {

        BigInteger bn = new BigInteger(String.valueOf(n));

        suma=suma.add(bn);

        //System.out.println("sumar " + String.valueOf(n) +" = "+ suma.toString());

    }

}
