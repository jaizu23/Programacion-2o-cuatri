import random

def distancia_maxima(alturas: list[int]) -> int:
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
                if medio:
                    return alturas[medio]
                
                elif alturas[medio] > alturas[medio - 1]:
                    izq = medio
                
                else:
                    dcha = medio


# Generamos las alturas del valle al puente de forma aleatoria
minimo = random.randint(25,200) # El mínimo será una distancia entre 25 y 500 metros
longitud_puente = 1000 # El puente medirá entre 50 y 200 metros

cantidad_izq = random.randint(1, longitud_puente) #s El número de medidas a la izquierda del mínimo
cantidad_dcha = longitud_puente - cantidad_izq # El número de medidas a la derecha del mínimo

print(cantidad_izq)
alturas_izq = sorted(random.sample(range(0, minimo - 1), cantidad_izq if cantidad_izq < minimo - 1 else minimo - 2), reverse=True) # Las medidas serán enteros aleatorios del 1 a la altura máxima
print(cantidad_dcha)
alturas_dcha = sorted(random.sample(range(0, minimo - 1), cantidad_dcha if cantidad_dcha < minimo - 1 else minimo - 2), reverse=False) # Las medidas serán enteros aleatorios del 1 a la altura máxima

alturas = []
(alturas.append(alturas_izq))
alturas.append(minimo)
alturas.append(alturas_dcha) # Unimos las alturas en una sola lista

print(distancia_maxima(alturas, 2))

         