Entrada = [(10, 12), (9, 11), (11, 13), (11, 15), (8, 12), (12, 16), (13, 14)]

def minimo_pistas (reservas: list[tuple[int,int]]) -> int:
    """Devuelve el minimo numero de pistas necesarias para que todas las reservas puedan llevarse a cabo sin solaparse"""
    
    if len(reservas) == 0:
        print("Error, la lista de reservas esta vacia")
        return None
    else:
        # Creamos una lista con tuplas en las que el primer elemento es una de las dos horas de una reserva. 
        # Si es la hora de inicio de la reserva lo representamos con un 1 en el segundo elemento de la tupla 
        # y si es la hora de finalización con un 0.

        horas = []
        for reserva in reservas:
            horas.append((reserva[0], 1))
            horas.append((reserva[1], 0))
        
        # Ordenamos la lista. La función sort ordena la tupla según su primer elemento de menor a mayor y si este elemento es igual
        # ordena según el segundo elemento, también de menor a mayor, es decir, ordenará por horas y de cada hora 
        # pondrá primero los eventos de finalización de una reserva y después los de inicio.
        horas.sort()

        # Inicializamos las variables pistasMaximasUsadas y pistasLiberadas.
        # pistasMaximasUsadas representará el máximo número de pistas usada hasta cierto momento.
        # pistasLiberadas representará pistasMaximasUsadas - nº de pistas en uso en cierto momento, o lo que es lo mismo,
        # las pistas que hace falta ocupar para llegar a pistasMaximasUsadas.
        pistasMaximasUsadas = 0
        pistasLiberadas = 0
        
        # Recorremos las horas de una en una y vemos si empieza o acaba alguna reserva.
        # Si empieza una reserva y pistasLiberadas es 0 significa que hemos llegado al número máximo de pistas
        # empleadas hasta el momento, por lo que aumentará en 1 el número máximo de pistas usadas hasta ahora.
        # Si acaba una pista aumenta en 1 el numero de pistasLiberadas.
        for hora in horas:
            if (hora[1] == 1):
                if (pistasLiberadas > 0):
                    pistasLiberadas -= 1
                else:
                    pistasMaximasUsadas += 1
            elif (hora[1] == 0):
                pistasLiberadas += 1
        
        return pistasMaximasUsadas
    
print (f"El numero minimo de pistas necesarias es {minimo_pistas(Entrada)}")



##############################
#          TESTS             #
##############################


def test_minimo_pista():
    Entrada = [(10, 12), (9, 11), (11, 13), (11, 15), (8, 12), (12, 16), (13, 14)]
    valor = [4]
    resultado = [] # Almacena el valor que devuelve minimo_pista
    resultado = [minimo_pistas(Entrada)]
    assert resultado == valor, 'El valor coincide' # Comprueva que el valor coincide

def test_benchmark_contar_caracteres():
    from Python import timer2 
    import random

    def rango_aleatorios( max, ranMin, ranMax):
        i = 0
        while i < max:
            yield (random.randInt(ranMin, ranMax), random.randInt(ranMin, ranMax))
            i += 1
    
    lista = list(rango_aleatorios(10000, 1, 10))

    @timer2.benchmark # Usa el decorador de la biblioteca timer
    def _timer_minimo_pistas(valores :list):
        return minimo_pistas(valores)
    
    timer2.warmup()
    print()
    for n in range(1000, 10001, 1000):
        nueva = lista[:n]
        resultado = _timer_minimo_pistas(nueva) 
        assert resultado[timer2.RESULT] == len(nueva), 'La longitud es correcta' # Comprueba el resultado de la función
        print(f'Elapsed time ({n}): {resultado[timer2.TIME]:.3f} ms') # Muestra el tiempo por pantalla


