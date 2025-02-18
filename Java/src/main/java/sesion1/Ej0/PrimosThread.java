package sesion1.Ej0;

// Clase PrimosThread sirve para calcular cuántos primos hay entre dos enteros
public class PrimosThread extends Thread {

    private final int x;
    private final int y;
    private final Resultado res;
    
    public PrimosThread(int x, int y, Resultado res){
        this.x=x;
        this.y=y;
        this.res = res;
    }
    
    private boolean esPrimo(int n){
        int raiz = (int) Math.sqrt((double) n);
        boolean primo = true;
        int i=2;
        while(primo && i<=raiz)
        {
            if (n % i == 0)
                primo=false;
            i++;
        }
        return primo;
    }
    
    @Override
    public void run(){
        for (int i=x; i<=y; i++)
        {
            if(esPrimo(i))
            {
                res.sumar(i);
            }
        }
    }
}