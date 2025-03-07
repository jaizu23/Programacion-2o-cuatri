"""
Un camionero conduce desde Bilbao a Málaga siguiendo una ruta dada y llevando
un camión que le permite, con el tanque de gasolina lleno, recorrer n kilómetros sin
parar. El camionero dispone de un mapa de carreteras que le indica las distancias
entre las gasolineras que hay en su ruta. Como va con prisa, el camionero desea
pararse a repostar el menor número de veces posible.
Diseñar un algoritmo voraz para determinar en qué gasolineras tiene que parar

No es un problema de grafos, tenemos que usar algoritmos voraces.
"""

gasolineras = [100, 45, 25, 200, 100]
distancia_max = 300       #Tendremos que parar en la gasolinera [3, 5]
def comSiguiente(gasolineras: list):
    solucion = []
    posicion = 0
    distancia_recorrida = 0

    while posicion < len(gasolineras) - 1:
        if gasolineras[posicion + 1] + distancia_recorrida > distancia_max:
            solucion += gasolineras[posicion]
            distancia_recorrida += gasolineras[posicion]
        posicion += 1

        return solucion
