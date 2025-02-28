Entrada = [(10, 12), (9, 11), (11, 13), (11, 15), (8, 12), (12, 16), (13, 14)]

def minimo_pistas (pistas: list[tuple[int,int]]) -> int:
    """Devuelve el minimo numero de pistas necesarias para que todas las reservas puedan llevarse a cabo sin solaparse"""
    
    if len(pistas) == 0:
        print("Error, la lista esta vacia")
        return None
    else:
        # Declaramos dos funciones anónimas que nos serán útiles para acceder a las horas de inicio y final de las reservas
        hora_inicio = lambda reserva: reserva[0]
        hora_final = lambda reserva: reserva[1]

        # Ordenamos la lista para que esten primero las reservas que empiezan antes
        pistas = sorted(pistas, key=hora_inicio)

        # Inicializamos las variables numeroPistas y pistasLibres y vemos de qué hora a qué hora tiene que estar abierto el complejo
        numeroPistas = 0
        pistasLibres = 0
        primeraHora = hora_inicio(pistas[0])
        ultimaHora = max(pistas, key=hora_final)[1]

        # Recorremos las horas de una en una y vemos si empieza o acaba alguna pista
        # Si empieza una pista y no hay libres aumenta el numero de pistas
        # Si acaba una pista aumenta el numero de pistas libres
        for hora in range(primeraHora, ultimaHora):
            for pista in pistas:
                if (hora == hora_inicio(pista)):
                    if (pistasLibres > 0):
                        pistasLibres -= 1
                    else:
                        numeroPistas += 1
                elif (hora == hora_final(pista)):
                    pistasLibres += 1
        
        return numeroPistas

print (f"El numero minimo de pistas necesarias es {minimo_pistas(Entrada)}")


