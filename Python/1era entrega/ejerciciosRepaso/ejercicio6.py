def obten_indices (vector: list[int]) -> list[int]:
    """Devuelve un vector con los indices de los elementos en orden"""

    def indices_aux (vector: list[int], inicio: int, fin: int) -> list[int]:
        """Emplea el método de merge_sort modificado para devolver la lista de indices"""

        if inicio > fin:
            return []
        elif inicio == fin:
            return [inicio]
        elif fin - inicio == 1:
            if vector[inicio] < vector[fin]:
                return [inicio, fin]
            else:
                return [fin, inicio]
        else:
            indices = []

            mitad = (fin + inicio) // 2
            izq = indices_aux(vector, inicio, mitad)
            dcha = indices_aux(vector, mitad + 1, fin)

            i, j = 0, 0
            while i < len(izq) and j < len(dcha):
                if vector[izq[i]] < vector[dcha[j]]:
                    indices.append(izq[i])
                    i += 1
                else:
                    indices.append(dcha[j])
                    j += 1
            
            return indices + izq[i:] + dcha[j:]
    
    return indices_aux(vector, 0, len(vector) - 1)
    
# Programa
lista = [50, 98, 10, 63, 31, 25, 63, 74]
print(f'Lista: {lista}')
indices = obten_indices(lista)
print(f'Indices: {indices}')