import doctest
def ordena_tramos(aristas):
    """ Lista --> lista
        Usando el peso como clave, ordena las aristas de menor a mayor """
    return sorted(aristas, key=lambda a: a[2])

def ciud_vistas(ciudades :list, arista :tuple):
    """ Actualiza los conjuntos """
    origen=set([])
    destino=set([])
    for c in ciudades:
        if arista[0] in c:
            origen=c
        if arista[1] in c:
            destino=c

    if origen != destino:
        ciudades.remove(origen)
        ciudades.remove(destino)
        ciudades.append(origen.union(destino))

def igual(ciudades, ciud_act):
    a=0
    for c in ciudades:
        if c!=ciud_act[a]:
            return False
        a+=1
    return True

def kruskal(aristas :list, ciudades :list) -> list:
    """ Algoritmo de Kruskal """
    aristas = ordena_tramos(aristas)
    solucion = []
    for arista in aristas:
        ciud_act=ciudades.copy()
        ciud_vistas(ciudades,arista)
        if not igual(ciudades,ciud_act):
            solucion.append(arista)
        ciud_act=ciudades.copy()
    
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

def calcularPesoArbol(aristas:list, ciudades: list) -> int:
    arbol_expansion_minima = kruskal(aristas, ciudades)
    peso_total= 0
    for arista in arbol_expansion_minima:
        print(arista)
        peso_total+=arista[2]
    return peso_total

print(calcularPesoArbol(aristas,ciudades))