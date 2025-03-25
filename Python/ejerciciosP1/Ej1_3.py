from Python.ejerciciosP1.Ej2 import *
def inserta_ordenado(lista :list, num :int) -> list:
    """ Devuelve la lista con el número insertado en orden ascendente """
    res = []                                                # O(1)
    if len(lista) == 0:                                     # 3*O(1) -> aprox(O(1))
        res += [num]                                        # 3*O(1) -> aprox(O(1))
    else:
        pos = 0                                             # 2*O(1) -> aprox(O(1))
        while pos < len(lista) and lista[pos] < num:        # Aplicando la fórmula: (6*O(1) + [6*O(1) + (Cuerpo: 2*O(1))] * n) -> aprox(O(n))	
            pos += 1                                        # 2*O(1) -> aprox(O(1))
        if pos == len(lista):                               # 3*O(1) -> aprox(O(1))
            res = lista + [num]                             # 2*O(1) + O(n) -> aprox(O(n))
        else:
            res = lista[:pos] + [num] + lista[pos:]         # O(1) + 4*O(n) -> aprox(O(n))
    return res 
          
pares = []                                                  # O(1)
impares = []                                                # O(1)                                      
for num in lista:                                           # Aplicando la fórmula: (O(1) + [O(1) + (Cuerpo: O(1) + O(n))] * n) -> aprox(O(n^2))     
    if num % 2 == 0:                                        # 3*O(1) -> aprox(O(1))
        pares = inserta_ordenado(pares, num)                # O(1) + O(n) -> aprox(O(n))
    else:                                                   # 3*O(1) -> aprox(O(1))
        impares = inserta_ordenado(impares, num)            # O(1) + O(n) -> aprox(O(n))
print(pares)                                                # O(1)  
print(impares)                                              # O(1)




