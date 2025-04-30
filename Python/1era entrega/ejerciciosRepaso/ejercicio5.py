"""
En Acelandia el deporte nacional es el tenis. Existe un ranking, donde cada jugador
tiene asignado un número de puntos en función de su calidad, es decir, el mejor
jugador de ese país es el que tiene más puntos. Cada año se debe seleccionar una
pareja entre todos los tenistas de Acelandia para jugar un torneo de dobles a nivel
internacional.
El procedimiento de selección es un poco peculiar. Se coloca la puntuación de
cada uno de los jugadores en una lista, de forma totalmente aleatoria, sin ningún
tipo de ordenación. Una vez hecha la lista, cada jugador solo puede formar pareja
con un jugador contiguo dentro de la lista, es decir, que esté delante o detrás de él
en esa lista.
Obviamente, el primer jugador de la lista solo puede formar pareja con el segundo
y el último con el penúltimo, pero el resto tiene dos posibles opciones para formar
la pareja de dobles, correspondientes a los jugadores anterior y posterior de la lista.
Con esta restricción, se elige la mejor pareja de dobles posible, que es aquella en
la que la suma de los puntos de sus dos componentes sea mayor.
Diseñar un algoritmo cuya función principal siga el esquema de divide y vencerás,
que decida qué pareja de dobles debe competir en Acelandia. Razonar cuál es la
complejidad del algoritmo.

Datos de entrada:
-> tenistas = [20, 50, 100, 30, 80, 10]

Salida:
-> solucion = (1, 2) #posiciones de los tenistas

Planteamiento:
-> Div y Ven
    - max(elegir(tenistas[:medio]), tenistas[medio] + tenistas[medio + 1],elegir(tenista[medio:])
    otra forma:
        - max(inicio + inicio+1, elegir(tenistas[inicio+1]))
"""

def mejor_pareja (parejas: list[int]) -> tuple[int, int]:
    """Devuelve la pareja contigua de enteros cuya suma sea máxima"""
    def mp_aux(parejas, inicio, final) -> int:
        # Casos base
        if inicio >= final:
            return -1
        elif final - inicio == 1:
            return inicio
        else:
            # Caso rec
            medio = (inicio + final) // 2
            izq = mp_aux(parejas, inicio, medio)
            dcha = mp_aux(parejas, medio + 1, final)

            suma = lambda list, int: list[int] + list[int + 1] 

            suma_medio = suma(parejas, medio)
            suma_izq = suma(parejas, izq)
            suma_dcha = suma(parejas, dcha)

            if suma_medio >= suma_izq and suma_medio >= suma_dcha:
                return medio    
            elif suma_izq >= suma_medio and suma_izq >= suma_dcha:
                return izq
            else:   
                return dcha
            
    posicion = mp_aux(parejas, 0, len(parejas) - 1)
    return (posicion, posicion + 1)

jugadores = [95, 79, 68, 68, 12, 43, 69, 97, 84, 83, 47]
print(f'Jugadores: {jugadores}')
pareja = mejor_pareja(jugadores)
print(f'Pareja: {pareja}')