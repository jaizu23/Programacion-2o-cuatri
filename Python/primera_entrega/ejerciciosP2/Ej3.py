V = [666666,3,4,77,1,2,3,6,7,85,4,-45,1,2,8,99,45,129,1062,6394,1,24,5,39]

def maximo_minimo (V: list[int]) -> tuple[int,int]:
    """Devuelve el maximo y el minimo de un vector de longitud n 
    en una tupla (maximo, minimo) empleando 3n/2 comparaciones como maximo"""

    if len(V) == 0:
        print("Error, el vector esta vacio")
        return None, None
    
    elif len(V) == 1:
        return V[0], V[0]
    
    else:
        # Inicializamos las variables cuentaComparaciones, maximo y minimo
        cuentaComparaciones = 0
        if V[0] > V[1]:
            maximo = V[0]
            minimo = V[1]
        else:
            maximo = V[1]
            minimo = V[0]
        
        # Vamos comparando por parejas y comparando el mayor de esta con el maximo y el menor de esta con el minimo
        for i in range(2, len(V)-1, 2):         
            cuentaComparaciones += 1            
            if V[i] > V[i+1]:            
                max_local = V[i]
                min_local = V[i+1] 
            else:
                max_local = V[i+1]
                min_local = V[i]    
                  
            cuentaComparaciones += 1
            if max_local > maximo:
                maximo = max_local
            cuentaComparaciones += 1
            if min_local < minimo:
                minimo = min_local
        
        # En caso de que el vector tenga longitud impar comparamos el ultimo elemento con el maximo y minimo
        if len(V) % 2 != 0:
            cuentaComparaciones += 1
            if V[-1] > maximo:
                maximo = V[-1]
            cuentaComparaciones += 1
            if V[-1] < minimo:
                minimo = V[-1]
    
    print(f"Se han realizado {cuentaComparaciones} comparaciones para un vector de longitud {len(V)}")    
    return maximo, minimo

print(maximo_minimo(V))


##############################
#          TESTS             #
##############################


def test_maximo_minimo():
    numeros    = [666666,3,4,77,1,2,3,6,7,85,4,-45,1,2,8,99,45,129,1062,6394,1,24,5,39]
    valores    = [666666, -45]
    resultados = [] # Almacena los valores que devuelve contar_caracteres con cada nombre
    resultados += [maximo_minimo(numeros)]
    assert resultados == valores, 'Todos los valores coinciden' # Comprueba que coinciden todos los valores

def test_benchmark_contar_caracteres():
    from Python import timer
    import random

    def rango_aleatorios( max, ranMin, ranMax):
        i = 0
        while i < max:
            yield random.randInt(ranMin, ranMax)
            i += 1
    
    lista = list(rango_aleatorios(10000, 1, 10))

    @timer.benchmark # Usa el decorador de la biblioteca timer
    def _timer_contar_caracteres(valores :list) -> tuple: # (resultado, tiempo)
        return maximo_minimo(valores)
    
    timer.warmup()
    print()
    for n in range(1000, 10001, 1000):
        nueva = lista[:n]
        resultado = _timer_contar_caracteres(lista) # Devuelve la tupla (resultado, tiempo)
        assert resultado[timer.RESULT] == len(lista), 'La longitud es correcta' # Comprueba el resultado de la función
        print(f'Elapsed time ({n}): {resultado[timer.TIME]:.3f} ms') # Muestra el tiempo por pantalla

