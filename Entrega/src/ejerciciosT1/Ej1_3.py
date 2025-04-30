from Ej1_2 import *
          
pares = []                                                  # O(1)
impares = []                                                # O(1)                                      
for num in lista:                                           # Aplicando la fórmula: (O(1) + [O(1) + (Cuerpo: O(1) + O(n))] * n) -> aprox(O(n^2))     
    if num % 2 == 0:                                        # 3*O(1) -> aprox(O(1))
        pares = inserta_ordenado(pares, num)                # O(1) + O(n) -> aprox(O(n))
    else:                                                   # 3*O(1) -> aprox(O(1))
        impares = inserta_ordenado(impares, num)            # O(1) + O(n) -> aprox(O(n))
print(pares)                                                # O(1)  
print(impares)                                              # O(1)