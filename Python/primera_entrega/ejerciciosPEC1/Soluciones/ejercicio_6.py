"""
Repaso PEC1 - Ejercicio 6

Modificar el algoritmo de ordenación por mezcla MergeSort para obtener 
el vector de índices de un vector V[1..N] dado como parámetro.

"""

def indices_ordenados(array: list) -> list:
    """ Devuelve una lista de índices ordenados con MergeSort """

    def _mergesort_indices(array :list, start :int, end :int) -> list:

        # Casos base
        if start > end:
            return []
        elif end == start:
            return [start]
        elif end - start == 2:
            if array[start] < array[end]:
                return [start, end]
            else:
                return [end, start]
        
        # Dividir el array en dos mitades y resolver recursivamente
        mid = (start + end) // 2
        left_indices = _mergesort_indices(array, start, mid)
        right_indices = _mergesort_indices(array, mid + 1, end)
        
        # Combinar los arrays
        sorted_indices = []
        i = j = 0
        while i < len(left_indices) and j < len(right_indices):
            if array[left_indices[i]] <= array[right_indices[j]]:
                sorted_indices.append(left_indices[i])
                i += 1
            else:
                sorted_indices.append(right_indices[j])
                j += 1
        
        # Añadir los elementos restantes
        sorted_indices += left_indices[i:] + right_indices[j:]
        
        return sorted_indices
    
    return _mergesort_indices(array, 0, len(array) - 1)


# Programa
lista = [50, 98, 10, 63, 31, 25, 63, 74]
print(f'Lista: {lista}')
indices = indices_ordenados(lista)
print(f'Indices: {indices}')
