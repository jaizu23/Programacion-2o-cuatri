import random

def distancia_maxima(alturas: list[int], epsilon: int) -> int:
    """Emplea búsqueda binaria para encontrar la distancia máxima, con una tolerancia de error de epsilon elementos.
    Se aplica un enfoque iterativo para evitar exceder la profundidad de recursión máxima"""                
            
    match len(alturas):
        case 0:
            return None
        case 1:
            return alturas[0]
        case 2:
            return max(alturas[0], alturas[1])    
        case n:
            izq, dcha = 0, n

            while izq < dcha:
                medio = (izq + dcha) // 2
                # En caso de encontrarnos en una zona plana con valores iguales, salimos de esta hacia la derecha
                if medio:
                    return alturas[medio]
                
                elif alturas[medio] > alturas[medio - 1]:
                    izq = medio
                
                else:
                    dcha = medio


# Generamos las alturas del valle al puente de forma aleatoria
minimo = random.randint(25,500) # El mínimo será una distancia entre 25 y 500 metros
longitud_puente = random.randint(50, 200) # El puente medirá entre 50 y 200 metros

cantidad_izq = random.randint(1, longitud_puente) # El número de medidas a la izquierda del mínimo
cantidad_dcha = 200 - cantidad_izq # El número de medidas a la derecha del mínimo

alturas_izq = [random.sample(range(0, cantidad_izq),1,minimo - 1)] # Las medidas serán enteros aleatorios del 1 a la altura máxima
alturas_dcha = [random.sample(range(0, cantidad_dcha),1,minimo - 1)] # Las medidas serán enteros aleatorios del 1 a la altura máxima
alturas_izq = alturas_izq.sort # La pendiente es constante por lo que las alturas estarán ordenadas
alturas_dcha = alturas_dcha.sort(reversed) #La pendiente es constante por lo que las alturas estarán ordenadas

alturas = alturas_izq.append(minimo).append(alturas_dcha) # Unimos las alturas en una sola lista

print(distancia_maxima(alturas, 2))

         