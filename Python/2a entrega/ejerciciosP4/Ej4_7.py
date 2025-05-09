import random

def encontrar_subsecuencia_maxima (A: list[int], B: list[int]) -> tuple[int, list[int]]:
    """
    Encuentra la subsecuencia de mayor longitud común a las dos secuencias A,B.
    Devuelve la longitud de la subsecuencia y la subsecuencia en sí.
    """
    if len(A) == 0 or len (B) == 0:
        return 0, []
    
    matriz = [[0] * (len(B) + 1) for _ in range(len(A) + 1)]

    for i in range(1, len(A) + 1):
        for j in range(1, len(B) + 1):
            if A[i-1] == B[j-1]:
                matriz[i][j] = matriz[i-1][j-1] + 1
            else:
                matriz[i][j] = max(matriz[i-1][j], matriz[i][j-1])
    
    longitud = matriz[i][j]
    subsecuencia = []

    while i > 0 and j > 0:
        if A[i-1] == B[j-1]:
            subsecuencia.append(A[i-1])
            i, j = i-1, j-1
        else:
            if matriz[i-1][j] > matriz[i][j-1]:
                i -= 1
            else:
                j -= 1
    
    subsecuencia.reverse()

    return longitud, subsecuencia

# Prueba simple de uso
A = [0,1,1,0,1,0,1,0]
B = [1,0,1,0,0,1,0,0,1]
print(encontrar_subsecuencia_maxima(A, B))



##############################
#          TESTS             #
##############################

def test_caso_limite1():
    A = []
    B = []
    solucion = encontrar_subsecuencia_maxima(A, B)
    assert solucion == (0, [])

def test_caso_limite2():
    A = ["a"]
    B = [1, 0, 1, 0, 1, 1]
    solucion = encontrar_subsecuencia_maxima(A, B)
    assert solucion == (0, [])

def test_caso_limite3():
    A = [random.randint(1, 0) for _ in range (100000)]
    B = [random.randint(1, 0) for _ in range (100000)]
    solucion = encontrar_subsecuencia_maxima(A[:100], B[100:200])
    assert solucion == encontrar_subsecuencia_maxima(A[:1000], B[1000:2000])