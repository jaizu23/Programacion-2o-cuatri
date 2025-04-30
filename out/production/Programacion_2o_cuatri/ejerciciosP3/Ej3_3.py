def encontrar_minimo(f, p1: int, p2: int, w):
    """Usamos busqueda ternaria para encontrar el valor minimo de la función (con una aprximacion de w)."""

    while p2 - p1 > w:
        corte1 = p1 + (p2 - p1)/3
        corte2 = p2 - (p2 - p1)/3

        if f(corte1) < f(corte2):
            p2 = corte2
        else:
            p1 = corte1
    return (p1 + p2)/2

def busqueda_binaria_en_monotonia(f, p1, p2, k, w, decrece):
    """Utilizamos busqueda binaria para encontrar los valores de k, solo se retornará uno 
    pues nos aseguramos de que la función sea monótona en el intervalo que le introducimos."""
    
    if decrece:
        if (f(p1) < k or f(p2) > k):
            return None
    else:
        if (f(p1) > k or f(p2) < k):
            return None
    
    while p2 - p1 > w:
        medio = (p2 + p1)/2

        if (f(medio) > k):
            if decrece:
                p1 = medio 
            else:
                p2 = medio
        else:
            if decrece:
                p2 = medio
            else:
                p1 = medio
    return (p1 + p2)/2

def encontrar_valores(f, p1, p2, k, w):
    """Usamos las funciones anteriores para encontrar el mínimo en la función y así poder buscar los valores en cada lado de la función."""

    min = encontrar_minimo(f, p1, p2, w)                           #O(log n)
    f_min = f(min)

    x1 = busqueda_binaria_en_monotonia(f, p1, min, k, w, True)     #O(log n)
    x2 = busqueda_binaria_en_monotonia(f, min, p2, k, w, False)    #O(log n)

    return (None if x1 == None else x1, None if x2 == None else x2)

# Prueba simple
def f(x: int):
    return (x + 3)**8

print(encontrar_valores(f, -5, 5, 3, 0.000000001))


##############################
#          TESTS             #
##############################

def test_encontrar_valores():
    funcion = lambda x: (x +3)**8
    numeros = [-1, 0, 1, 2, 3]
    valores    = [(None, None), (None, None), (-4-0, -2.0), (-4.091, -1.909), (-4.147, -1.853)]
    resultados = [] 
    i = 0
    while  i < len(numeros):
        res = encontrar_valores(funcion, -5, 5, numeros[i], 0.000000001)
        resultados.append((None if res[0] == None else round(res[0], 3), None if res[1] == None else round(res[1], 3)))
        i += 1
    assert resultados == valores, 'Todos los valores coinciden' 
