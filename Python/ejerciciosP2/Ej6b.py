Entrada = [(10, 12), (9, 11), (11, 13), (11, 15), (8, 12), (12, 16), (13, 14)]

def minimo_pistas (pistas: list[tuple[int,int]]) -> int:
    """Devuelve el minimo numero de pistas necesarias para que todas las reservas puedan llevarse a cabo sin solaparse"""
    
    if len(pistas) == 0:
        print("Error, la lista esta vacia")
        return None
    else:
        # Creamos una lista