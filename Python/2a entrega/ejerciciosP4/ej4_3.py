
from math import inf

def cambio(billetes: list, cantidades: list, total: int):

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

    for i in range(aux, 0, -1):
        k = matriz_cantidades[i][d]
        x[i-1] = k
        d -= k * billetes[i-1]
    
    return True, matriz_billetes[aux][total], x       #retornamos el valor de la matriz que nos dice la cantidad de billetes necesarios para el cambio
                                                      #En la variable x guardamos los billetes necesarios para el cambio.





##############################
#          TESTS             #
##############################

def test_caso_base():

    v = [1, 2, 5, 10, 20, 50, 100]     #billetes
    c = [3, 3, 6, 2, 1, 0, 1]          #cantidad de cada billete
    D = 153                            #cantidad a cambiar a los billetes que se indican

    posible, total, x = cambio(v, c, D)
    if posible:
        print(f"Para pagar {D}€ se usan {total} billetes:")
        for vi, xi in zip(v, x):                        #usamos zip() para emparejar los elementos de las listas de billetes y cantidades y así poder tener la catidad de cada billete que se necesita.
            if xi > 0:                                  #nos saltamos los billetes de los que se necesitan 0 (redundante)
                print(f" {xi} x {vi}€")
    else:
        print("No es posible dar el cambio.")