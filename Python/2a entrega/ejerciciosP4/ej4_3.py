from math import inf
import random

def cambio(billetes: list, cantidades: list, total: int):
    """
    Calcula si es posible devolver el cambio exacto para el total especificado.
    Si es posible devuelve el número de billetes de cada tipo necesarios para este fin.
    """
    if len(billetes) == 0 or len(cantidades) == 0 or len(billetes) != len(cantidades) or total < 0:
        return False, 0, []

    aux = len(billetes)

    matriz_billetes = [[inf] * (total + 1) for i in range(aux+1)]
    matriz_billetes[0][0] = 0    #se necesitan 0 billetes para la cantidad 0
    matriz_cantidades = [[0] * (total + 1) for i in range(aux+1)]

    for i in range(1, aux+1):      #evitamos errores saltandonos i=0
        billetes_i = billetes[i-1]
        cantidades_i = cantidades[i-1]

        for j in range(total+1):
            matriz_billetes[i][j] = matriz_billetes[i-1][j]
            matriz_cantidades[i][j] = 0

        for j in range(total+1):
            if matriz_billetes[i-1][j] != inf:
                max = min(cantidades_i, (total - j)//billetes_i)
                base = matriz_billetes[i-1][j]

                for k in range(1, max+1):
                    nd = j +k*billetes_i
                    candidato = base + k

                    if candidato < matriz_billetes[i][nd]:
                        matriz_billetes[i][nd] = candidato
                        matriz_cantidades[i][nd] = k

    if matriz_billetes[aux][total] == inf:
        return False, 0, []    #no se ha encontrado el cambio
    
    x = [0]*aux
    d = total                  #lo guardamos en otra variable para no alterar el valor a retornar

    for i in range(aux, 0, -1):         #se recorre la matriz de forma inversa y se almacena la solución
        k = matriz_cantidades[i][d]
        x[i-1] = k
        d -= k * billetes[i-1]
    
    return True, matriz_billetes[aux][total], x       #retornamos el valor de la matriz que nos dice la cantidad de billetes necesarios para el cambio
                                                      #En la variable x guardamos los billetes necesarios.


#ejemplo sencillo de uso:

v = [1, 5, 10, 20, 50, 100]
c = [2, 0, 2, 1, 3, 1]
D = 182
posible, total, x = cambio(v, c, D)
if posible:
    print(f"Para pagar {D}€ se usan {total} billetes:")
    for vi, xi in zip(v, x):                        #usamos zip() para emparejar los elementos de las listas de billetes y cantidades y así poder tener la catidad de cada billete que se necesita.
        if xi > 0:                                  #nos saltamos los billetes de los que se necesitan 0 (redundante)
            print(f" {xi} x {vi}€")
else:
    print("No es posible dar el cambio exacto.")

##############################
#          TESTS             #
##############################

def test_caso_limite():
    v = []     
    c = []          
    D = 153                            

    es_posible, cantidad, cantidades = cambio(v, c, D)
    assert (es_posible, cantidad, cantidades) == (False, 0, [])

def test_caso_limite3(benchmark):
    n = 500
    valor_max = 1000
    random.seed(13)
    v = sorted([random.randint(0, valor_max) for _ in range(n)])
    print(v)
    random.seed(23)
    c = [random.randint(0, 20) for _ in range(n)]
    print(c)
    D = 5433
    solucion = benchmark(cambio, v, c, D)
    assert solucion ==  (True, 6, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 5, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
                                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0])
