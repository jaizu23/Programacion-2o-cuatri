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

def min_farolas(farolas_radios, puntos):
    # Ordenamos las farolas por el inicio de su rango de iluminación
    farolas_radios.sort(key=lambda x: x[0] - x[1])
    # Ordenamos los puntos
    puntos.sort()
    
    solucion = []
    i = 0
    for punto in puntos:
        # Mientras la farola actual no ilumine el punto, avanzamos
        while i < len(farolas_radios) and farolas_radios[i][0] + farolas_radios[i][1] < punto:
            i += 1
        # Si no hay farolas que iluminen el punto, devolvemos una lista vacía
        if i == len(farolas_radios) or farolas_radios[i][0] - farolas_radios[i][1] > punto:
            return []
        # Añadimos la farola a la solución
        solucion.append(farolas_radios[i][0])
        # Avanzamos a la siguiente farola
        i += 1
    
    return solucion

# Datos de entrada
farolas_radios = [(70, 10), (20, 15), (50, 15), (30, 10)]
puntos = [2, 3, 76]

# Llamada a la función
solucion = min_farolas(farolas_radios, puntos)
print(solucion)