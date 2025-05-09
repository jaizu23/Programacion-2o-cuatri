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
        Tn = binom(m - 1, n - 1) * p^n * (1-p)^(m-n)
        El coeficiente binomial cuenta las posibles combinaciones de colocar n - 1 éxitos en m - 1 partidos,
        ya que tenemos asegurado que el partido m es una victoria del equipo 1 porque si no, el equipo 1
        habría ganado n partidos en menos de m partidos. Todo esto multiplicado por la probabilidad de
        que el éxito ocurra n veces y el fracaso m-n veces.

para k <= m partidos:
    esto se puede calcular como la suma de las probabilidades de que el equipo 1 gane n partidos
    en k partidos, con n <= k <= m:
        Pn = sum(Tn, k=n, m)

buscamos la probabilidad 

Salida:
ganancia: int"""