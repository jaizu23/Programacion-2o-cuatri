def devuelve_billetes (billetes: list[int], cantidades: list[int], dinero: int) :
    matriz = [0 for _ in range(len(billetes))]

    billetes.reverse()
    for i, billete in enumerate(billetes):
        for j in range(cantidades[i], -1, -1):
            if billete * (j+1) < dinero:
                matriz[-i - 1] = (j+1)
                dinero -= billete * (j+1)
                break
        
    return dinero == 0, matriz

billetes = [5, 10, 20, 50, 100, 200]
cantidades = [6, 3, 5, 2, 7, 2]
dinero = 734

print(devuelve_billetes(billetes, cantidades, dinero))