"""
Repaso PEC1 - Ejercicio 4

Se tiene un vector V[1..N] formado por números enteros, de manera que todos ellos distintos, 
y que están ordenados de manera creciente. Se dice que un vector de estas características es 
coincidente si tiene al menos una posición tal que es igual al valor que contiene el vector 
en esa posición.

"""

def es_coincidente(lista :list) -> bool:
    """ Devuelve si un valor coincide con su posición en V ordenado """

    def _es_coincidente(lista :list, ini :int, fin :int) -> bool:
        if ini == fin:
            return lista[ini] == ini + 1
        else:
            medio = (ini + fin) // 2
            if lista[medio] == medio + 1:
                return True
            elif lista[medio] > medio:
                return _es_coincidente(lista, ini, medio - 1)
            else:
                return _es_coincidente(lista, medio + 1, fin)
        
    return _es_coincidente(lista, 0, len(lista) - 1)

lista = [-14, -6, 2, 6, 16, 18, 27, 43]
print(es_coincidente(lista))
lista[2] = 3
print(es_coincidente(lista))
