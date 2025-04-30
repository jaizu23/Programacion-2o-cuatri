U = 0
V = 1
PESO = 2

def ordena_tramos(aristas :list) -> list:
    """ Ordena las aristas por peso de menor a mayor """
    peso = lambda arista: arista[PESO]
    return sorted(aristas, key=peso)

def find(conjuntos :list, u :int) -> set:
    """ Devuelve el conjunto al que pertenece un nodo """
    for conjunto in conjuntos:
        if u in conjunto:
            return conjunto
    return None

def union(conjuntos :list, arista :tuple) -> None:
    """ Actualiza los conjuntos """
    set_u = find(conjuntos, arista[U])
    set_v = find(conjuntos, arista[V])
    if set_u != set_v:
        conjuntos.remove(set_u)
        conjuntos.remove(set_v)
        conjuntos.append(set_u.union(set_v))

def is_bucle(conjuntos :list, arista :tuple) -> bool:
    """ Hay un bucle si los nodos pertenecen al mismo conjunto (algoritmo union-find) """
    set_u = find(conjuntos, arista[U])
    set_v = find(conjuntos, arista[V])

    return set_u == set_v

def kruskal(aristas :list, conjuntos :list) -> list:
    """ Algoritmo de Kruskal """
    aristas = ordena_tramos(aristas)
    solucion = []
    for arista in aristas:
        if not is_bucle(conjuntos, arista):
            solucion.append(arista)
            union(conjuntos, arista)
    return solucion


# Programa
ciudades = [{"Madrid"}, {"Segovia"}, {"Burgos"}, {"Cádiz"}, {"Valencia"}, {"Toledo"}, {"Barcelona"}, {"Vitoria"}]
aristas = []
aristas.append(("Madrid", "Segovia", 3000))
aristas.append(("Segovia", "Burgos", 10000))
aristas.append(("Burgos", "Vitoria", 5000))
aristas.append(("Madrid", "Toledo", 5000))
aristas.append(("Toledo", "Cádiz", 15000))
aristas.append(("Madrid", "Valencia", 12000))
aristas.append(("Madrid", "Barcelona", 15000))
aristas.append(("Barcelona", "Valencia", 8000))
aristas.append(("Cádiz", "Valencia", 17000))
aristas.append(("Barcelona", "Vitoria", 6000))
aristas.append(("Vitoria", "Madrid", 16000))
aristas.append(("Madrid", "Cádiz", 19000))

def calcularPesoArbol(aristas:list, nodos: list) -> int:
    arbol_expansion_minima = kruskal(aristas, nodos)
    peso_total= 0
    for arista in arbol_expansion_minima:
        print(arista)
        peso_total+=arista[2]
    return peso_total


##############################
#          TESTS             #
##############################

def test_calcular_peso_minimo (benchmark):
    def calcularPesoArbolBenchmark() -> int:
        """ Función para calcular el Benchmark ya que en iteraciones sucesivas de la funcion
        calcularPesoArbol los argumentos al ser listas se modifican sus elementos y no se pasan a la función los argumentos inciales.
        En esta función creamos las listas cuidades y aristas de nuevo en cada iteración de la función"""
        
        ciudades = [{"Madrid"}, {"Segovia"}, {"Burgos"}, {"Cádiz"}, {"Valencia"}, {"Toledo"}, {"Barcelona"}, {"Vitoria"}]
        aristas = []
        aristas.append(("Madrid", "Segovia", 3000))
        aristas.append(("Segovia", "Burgos", 10000))
        aristas.append(("Burgos", "Vitoria", 5000))
        aristas.append(("Madrid", "Toledo", 5000))
        aristas.append(("Toledo", "Cádiz", 15000))
        aristas.append(("Madrid", "Valencia", 12000))
        aristas.append(("Madrid", "Barcelona", 15000))
        aristas.append(("Barcelona", "Valencia", 8000))
        aristas.append(("Cádiz", "Valencia", 17000))
        aristas.append(("Barcelona", "Vitoria", 6000))
        aristas.append(("Vitoria", "Madrid", 16000))
        aristas.append(("Madrid", "Cádiz", 19000))

        return calcularPesoArbol(aristas, ciudades)
    
    resultado = benchmark(calcularPesoArbolBenchmark)
    assert resultado == 52000, 'El valor no coincide'

def test_calcular_peso_minimo_vacio (benchmark):
    ciudades = []
    aristas = []

    resultado = benchmark(calcularPesoArbol, aristas, ciudades)
    assert resultado == 0, 'El valor no coincide'