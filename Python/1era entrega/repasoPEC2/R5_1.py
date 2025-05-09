def permutaciones (lista: list[int]) -> list[list[int]]:
    perm = [[]]

    for valor in lista:
        lista.remove(valor)
        if lista:
            subper = permutaciones (lista)
            for i in len(range(subper)):
                subper[i].insert(valor, 0)
            perm.extend()
            perm.extend(subper.append(valor)) 

    return perm

# Prueba simple de uso
print(permutaciones([1,2,3,4,5]))