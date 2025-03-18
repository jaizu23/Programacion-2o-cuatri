"""
Se tienen n esquiadoras de alturas H = [h1, h2, … , hn] y n pares de esquíes de
longitudes S = [s1, s2, … , sn]. Diseñar un algoritmo que, usando un esquema voraz,
asigne los esquíes a las esquiadoras de modo que el promedio de la diferencia (en
valor absoluto) entre la altura de la esquiadora y la longitud de los esquíes
asignados sea mínima.

Salida:
-> Tuplas [altura, longitud]:    [(1,55),...]

Planteamineto:
-> ordenar las dos listas de menor a mayor.
-> mientras queden elementos: 
    -> añadir un elemento de cada lista.
"""

def esquiadoras (esquiadoras: list[int], )