def minimo_pistas (reservas: list[tuple[int,int]]) -> int:
    """Devuelve el minimo numero de pistas necesarias para que todas las reservas puedan llevarse a cabo sin solaparse"""
    
    if len(reservas) == 0:
        print("Error, la lista de reservas esta vacia")
        return None
    else:
        # Creamos una lista con tuplas que registran eventos de inicio o fin de reserva
        horas = []
        for reserva in reservas:                # O(n)
            horas.append((reserva[0], 1))
            horas.append((reserva[1], 0))
        
        # Ordenamos la lista.
        horas.sort()                            # O(n log n)     

        # Inicializamos las variables pistasMaximasUsadas y pistasLiberadas.
        pistasMaximasUsadas = 0
        pistasLiberadas = 0
        
        # Recorremos las horas de una en una y vemos si empieza o acaba alguna reserva.
        for hora in horas:                      # O(n)
            if (hora[1] == 1):
                if (pistasLiberadas > 0):
                    pistasLiberadas -= 1
                else:
                    pistasMaximasUsadas += 1
            elif (hora[1] == 0):
                pistasLiberadas += 1
        
        return pistasMaximasUsadas
    
# Prueba simple
Entrada = [(10, 12), (9, 11), (11, 13), (11, 15), (8, 12), (12, 16), (13, 14)]
print (f"El numero minimo de pistas necesarias es {minimo_pistas(Entrada)}")


##############################
#          TESTS             #
##############################

def test_minimo_pista_vacia():
    Entrada = []
    valor = None
    resultado = []
    resultado = minimo_pistas(Entrada)
    assert resultado == valor, 'Los valores no coinciden'

def test_minimo_pista():
    Entrada = [(10, 12), (9, 11), (11, 13), (11, 15), (8, 12), (12, 16), (13, 14)]
    valor = [4]
    resultado = [minimo_pistas(Entrada)] # Almacena el valor que devuelve minimo_pista
    assert resultado == valor, 'El valor no coincide' # Comprueba que el valor coincide

def test_benchmark_contar_caracteres():
    from Python import timer2 
    import random

    def rango_aleatorios( max, ranMin, ranMax):
        i = 0
        while i < max:
            yield (random.randint(ranMin, ranMax), random.randint(ranMin, ranMax))
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
        res2 = minimo_pistas(nueva)
        assert resultado[timer2.RESULT] == res2, 'La longitud es incorrecta' # Comprueba el resultado de la función
        print(f'Elapsed time ({n}): {resultado[timer2.TIME]:.3f} ms') # Muestra el tiempo por pantalla


