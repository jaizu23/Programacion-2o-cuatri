def traspuesta (matriz: list[list[int]]):
    """Calcula la traspuesta de la matriz de adyacencia mediante un algoritmo 
    del tipo divide y vencerás. La complejidad es O(n^2)"""

    # Casos base
    if len(matriz) == 1:
        return [[valor] for valor in matriz[0]]
    elif len(matriz[0]) == 1:
        return [[valor[0] for valor in matriz]]
    else:
        # Hallamos el punto medio de la matriz (es cuadrada)
        mitad = len(matriz)//2

        # Dividimos la matriz en 4 submatrices
        M1_1 = [fila[:mitad] for fila in matriz[:mitad]]
        M1_2 = [fila[mitad:] for fila in matriz[:mitad]]
        M2_1 = [fila[:mitad] for fila in matriz[mitad:]]
        M2_2 = [fila[mitad:] for fila in matriz[mitad:]]

        # Transponemos las submatrices
        MT1_1 = traspuesta(M1_1)
        MT1_2 = traspuesta(M1_2)
        MT2_1 = traspuesta(M2_1)
        MT2_2 = traspuesta(M2_2)

        # Unimos las matrices transpuestas
        M1 = []
        for i in range(len(MT1_1)):
            M1.append(MT1_1[i] + (MT2_1[i]))
        M2 = []
        for j in range(len(MT1_2)):
            M2.append(MT1_2[j] + (MT2_2[j]))

        return M1 + M2



matriz = [
    [0, 0, 0, 1, 0], 
    [0, 0, 1, 0, 1], 
    [1, 1, 0, 0, 0], 
    [1, 1, 0, 1, 1], 
    [1, 0, 1, 0, 0]
]
print(traspuesta(matriz))


##############################
#          TESTS             #
##############################


def test_traspuesta():
    Entrada = [[
    [0, 0, 0, 1, 0], 
    [0, 0, 1, 0, 1], 
    [1, 1, 0, 0, 0], 
    [1, 1, 0, 1, 1], 
    [1, 0, 1, 0, 0]
],[
    [1, 2, 3], 
    [4, 5, 6], 
    [7, 8, 9], 
    [10, 11, 12]
],[
    [5, 6], 
    [7, 8], 
    [9, 10]
]]
    valores = [[
    [0, 0, 1, 1, 1], 
    [0, 0, 1, 1, 0], 
    [0, 1, 0, 0, 1], 
    [1, 0, 0, 1, 0], 
    [0, 1, 0, 1, 0]
],[
    [1, 4, 7, 10], 
    [2, 5, 8, 11], 
    [3, 6, 9, 12]
],[
    [5, 7, 9], 
    [6, 8, 10]
]]
    resultado = [] # Almacena el valor que devuelve traspuesta()
    for matriz in Entrada:
        resultado.append(traspuesta(matriz))
    assert resultado == valores, 'Las matrices no coinciden' # Comprueva que el valor coincide