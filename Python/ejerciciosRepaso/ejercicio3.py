"""
Hay M farolas en las posiciones y1, y2, … , yM de una recta y NM puntos x1, x2, … , xN.
Cada farola tiene un radio de iluminación ri, tal que la i-ésima farola ilumina puntos
en el intervalo [yi - ri, yi + ri]. Se quiere encender el mínimo número de farolas
tales que cada uno de los N puntos x1, x2, … , xN esté iluminado por al menos una
farola. Encuentra este mínimo número.

Datos de entrada:
-> farolas_radios = [(70, 10), (20, 15), (50, 15), (30, 10)]  #ej: [(distancia_al_origen, radio_de_iluminación), ...]
-> puntos = [2, 3, 76] #distancias

salida:
-> solucion = [20, 30]

planteamineto:
-> ordenar farolas y puntos de menor a mayor 
"""