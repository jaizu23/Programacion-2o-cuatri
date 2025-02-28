Entrada = [(10, 12), (9, 11), (11, 13), (11, 15), (8, 12), (12, 16), (13, 14)]

def minimo_pistas (pistas: list[tuple[int,int]]) -> int:
    """Devuelve el minimo numero de pistas necesarias para que todas las reservas puedan llevarse a cabo sin solaparse"""
    
    if len(pistas) == 0:
        print("Error, la lista esta vacia")
        return None
    else:
        # Creamos una lista de horas con tuplas que representan cierta hora y si empieza o acaba una reserva a tal hora,
        # representando con 1 que empiece y con 0 que acabe

        horas = []
        for reserva in Entrada:
            horas.append((reserva[0], 1))
            horas.append((reserva[1], 0))
        
        # Ordenamos las horas de menor a mayor y si son la misma hora primero las pistas que acaben para que 
        # se represente correctamente que dejan la pista libre para los que van a empezar
        horas.sort()

        # Inicializamos las variables numeroPistas y pistasLibres
        numeroPistas = 0
        pistasLibres = 0
        
        # Recorremos las horas de una en una y vemos si empieza o acaba alguna pista
        # Si empieza una pista y no hay libres aumenta el numero de pistas
        # Si acaba una pista aumenta el numero de pistas libres
        for hora in horas:
            if (hora[1] == 1):
                if (pistasLibres > 0):
                    pistasLibres -= 1
                else:
                    numeroPistas += 1
            elif (hora[1] == 0):
                pistasLibres += 1
        
        return numeroPistas
    
print (f"El numero minimo de pistas necesarias es {minimo_pistas(Entrada)}")