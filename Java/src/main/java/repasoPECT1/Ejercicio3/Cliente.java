package main.java.repasoPECT1.Ejercicio3;

/**
 * Comportamiento:
 * 1-Los clientes echarán un vistazo a los productos y tomarán aquellos que 
 * desean probarse de forma aleatoria, pudiendo coger de 0 a 5 prendas
 * 2-Si tienen alguna prenda para probarse acudirán a uno de los 4 probadores de 
 * la tienda, tan pronto como esté alguno disponible. En este punto se imprimirá 
 * por pantalla el identificador la información del cliente, el probador al que 
 * ha accedido y el número de prendas.
 * 3-El cliente tarda 2 segundos en probarse cada prenda.
 * 4-Finalmente, en caso de que le haya gustado alguna prenda (se realizará de 
 * forma aleatoria), acudirá a la única caja disponible para pagar, tardando 1 
 * segundo en llevar a cabo esta acción para cada prenda. Una vez ha pagado, 
 * abandonará la tienda.
 */
public class Cliente extends Thread
{
    private TiendaRopa tienda;
    private int idCliente;
    
    public Cliente(TiendaRopa tienda, int idCliente)
    {
        this.tienda = tienda;
        this.idCliente=idCliente;
    }
    
    @Override
    public void run()
    {
        try
        {
        //1-Echan un vistazo y seleccionan las prendas a probarse 
        int prendas = (int)(5*Math.random());
        sleep(200 * prendas);  //No está en el enunciado pero así le damos más pausa

        //2-Si tienen alguna prenda acude a los probadores 
        if(prendas>0)
        {
            //3-Seleccionar probador y probarse la ropa
            int probador = tienda.entrarProbador(idCliente, prendas);
            sleep(2000 * prendas);
            tienda.salirProbador(idCliente, probador);
            
            //4-Si le gusta alguna prenda pasar por caja
            prendas = (int) (prendas * Math.random());
            if(prendas>0)
            {
                tienda.pagar(idCliente, prendas);
            }
        }
        }catch(InterruptedException e)
        {
            System.out.println("Error en el cliente: " + e);
        }
    }
}
