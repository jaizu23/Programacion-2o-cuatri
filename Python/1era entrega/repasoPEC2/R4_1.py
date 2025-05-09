def calcula_costes (matriz: list[list[int]]) -> int:
    """
    Calcula el coste del menor camino de la matriz.
    
    Args:
        matriz (list[list[int]]): Matriz de costes.
    
    Returns:
        int: Coste del menor camino.
    """

    matriz_costes = [[0 for _ in range(len(matriz[0]))] for _ in range(len(matriz))]
    matriz_caminos = [[[] for _ in range(len(matriz[0]))] for _ in range(len(matriz))]

    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            if i == 0 and j == 0:
                matriz_costes[i][j] = matriz[i][j]
            elif i == 0:
                matriz_costes[i][j] = matriz_costes[i][j-1] + matriz[i][j]
                matriz_caminos[i][j] = matriz_caminos[i][j-1] + ["Derecha"]
            elif j == 0:
                matriz_costes[i][j] = matriz_costes[i-1][j] + matriz[i][j]
                matriz_caminos[i][j] = matriz_caminos[i-1][j] + ["Abajo"]
            else:
                if matriz_costes[i-1][j] <= matriz_costes[i][j-1]:
                    matriz_costes[i][j] = matriz_costes[i-1][j] + matriz[i][j]
                    matriz_caminos[i][j] = matriz_caminos[i-1][j] + ["Abajo"]
                else:
                    matriz_costes[i][j] = matriz_costes[i][j-1] + matriz[i][j]
                    matriz_caminos[i][j] = matriz_caminos[i][j-1] + ["Derecha"]
    return matriz_costes[-1][-1], matriz_caminos[-1][-1]

matriz = [ [3, 2, 3, 2, 5],
           [1, 2, 4, 5, 6],
           [4, 3, 6, 2, 4],
           [2, 5, 3, 4, 3] ]

camino = calcula_costes(matriz)
print(f"El menor coste y el mejor camino son: {camino}")  # Salida: 24