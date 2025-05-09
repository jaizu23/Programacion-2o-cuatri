"""
Entrada: 
valores_calidad: list[int] (4 elementos)
partidos_para_ganar : int
dinero_apostado: int

El algoritmo calcula la ganancia si gana el equipo 1 n partidos seguidos con probabilidad determinada
por los valores de calidad de los equipos. (dinero_apostado/probabilidad)

La probabilidad se calcula como:
para cada partido:
    probabilidad = (valores_calidad[0] * 100 / sum(valores_calidad))
para m partidos:
    la probabilidad de que el equipo 1 gane n partidos en exactamente m partidos es:
        Ya que tenemos asegurado que el partido m es una victoria del equipo 1 porque si no, el equipo 1
        habría ganado n partidos en menos de m partidos, en el partido m-1 el equipo 1 tiene que
        haber ganado n-1 partidos y el resto de equipos colectivamente m-1 - (n-1) = m-n partidos.
        Sean x2, x3, x4 los partidos ganados por los equipos 2, 3 y 4 respectivamente, entonces:
        x2 + x3 + x4 = m - n y xi <= n - 1.
        El número de combinaciones de partidos ganados en la ronda m-1 tal que se cumplan las condiciones
        anteriores es:
        (m-1)! / (n-1)! * x2! * x3! * x4! (combinaciones de m partidos en los que los equipos ganan
        el número de partidos establecidos anteriormente)

        Sean p1, p2, p3, p4 las probabilidades de que el equipo 1, 2, 3 y 4 ganen un partido respectivamente.
        Entonces la probabilidad de que el equipo 1 gane n - 1 partidos en m - 1 partidos es:
        (m-1)! / (n-1)! * x2! * x3! * x4! * p1**(n-1) * p2**x2 * p3**x3 * p4**x4
        Como en la ronda m gana el equipo 1 con probabilidad p1, la probabilidad de que el 
        equipo 1 gane n partidos en m partidos es:
        Tn,m = (m-1)! / (n-1)! * x2! * x3! * x4! * p1**n * p2**x2 * p3**x3 * p4**x4
        Como queremos considerar todas las posibilidades de x2, x3 y x4, sumamos todas estas combinaciones:
        Con n <= k <= m:
        Qn,m = sum(Tn,k)_{x2,x3,x4 = k - n}

    para m o menos partidos:
        Para hallar la probabilidad de que ocurra en m o menos partidos, al menos n partidos, simplemente
        sumamos todas las probabilidades con n <= k <= m:
        Pn,m = sum(Qn,k)_{k = n}^infinito
        Con un cambio de indice i = k - n, la suma se convierte en:
        Pn,m = sum(sum((m-1)! / (n-1)! * x2! * x3! * x4! * p1**n * p2**x2 * p3**x3 * p4**x4)_{x2,x3,x4 = i})_{i = 0}^infinito
        
Como el máximo de partidos es x2,x3,x4 = 3(n-1), tomamos i = 3n - 3 y calculamos la probabilidad

Finalmente, la ganancia se calcula como:
ganancia = dinero_apostado / Pn,m

Salida:
ganancia: int"""

def calcula_probabilidad (valores_calidad: list[float], N: int, D: int):
    p = [0] * 4
    total_valores = sum(valores_calidad)
    for i, valor in enumerate(valores_calidad):
        p[i] = valor / total_valores

    M = N * 4 - 3
    probabilidad = {}
    probabilidad[(-1, -1, -1, -1)] = 1.0
    probabilidad_total_v1 = 0.0

    for v1 in range(M):
        for v2 in range(M - v1):
            for v3 in range(M - v1 - v2):
                for v4 in range(M - v1 - v2 - v3):
                    if v4 < 0 or v4 > N:
                        continue
                    elif v2 == N or v3 == N or v4 == N:
                        probabilidad[(v1, v2, v3, v4)] = 0.0

                    p1 = p[0] * probabilidad[v1 - 1, v2, v3, v4] if v1 > 1 else p[0] if v1 == 1 else 0.0
                    p2 = p[1] * probabilidad[v1, v2 - 1, v3, v4] if v2 > 1 else p[1] if v2 == 1 else 0.0
                    p3 = p[2] * probabilidad[v1, v2, v3 - 1, v4] if v3 > 1 else p[2] if v3 == 1 else 0.0
                    p4 = p[3] * probabilidad[v1, v2, v3, v4 - 1] if v4 > 1 else p[3] if v4 == 1 else 0.0

                    p_buscada =  p1 + p2 + p3 + p4
                            
                    if v1 == N: 
                        probabilidad_total_v1 += p_buscada
                    
                    probabilidad[(v1, v2, v3, v4)] = p_buscada
    
    return D / probabilidad[0,0,0,0]

# Prueba simple de uso
print(calcula_probabilidad([1, 1, 1, 1], 9, 10))