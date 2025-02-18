# Algoritmia y Complejidad Curso 2024-25 

##############################
#        BIBLIOTECA          #
##############################
from typing import TextIO


def contar_lineas(fichero :TextIO) -> int:
    """
        Cuenta cuantas líneas tiene el fichero pasado como argumento
    """
    contador = 0
    for _línea in fichero:
        contador = contador + 1
    return contador


def contar_caracteres(cadena :str) -> int:
    """
        Cuenta cuantos carácteres tiene la cadena.
    """
    def _contar(s, n): # El worker trabaja (la función no es accesible desde fuera)
        if not s:
            return n
        else:
            return _contar(s[1:], n + 1)

    return _contar(cadena, 0) # El wrapper inicializa



##############################
#          TESTS             #
##############################
# Pytest ejecuta las funciones que empiezan por test_
def tesst_contar_caracteres():
    nombres    = ['Ángel', 'Pepe', 'angel', 'josé']
    valores    = [5, 4, 5, 4]
    resultados = [] # Almacena los valores que devuelve contar_caracteres con cada nombre
    for nombre in nombres:
        resultados += [contar_caracteres(nombre)]
    assert resultados == valores, 'Todos los valores coinciden' # Comprueba que coinciden todos los valores

def tesst_benchmark_contar_caracteres_10(benchmark):
    cadena = '_' * 10 # Genera una cadena de longitud 10
    resultado = benchmark(contar_caracteres, cadena) # Mide el tiempo que tarda contar_caracteres
    assert resultado == len(cadena) # Comprueba que el resultado de la función es correcto

def tesst_benchmark_contar_caracteres_100(benchmark):
    cadena = '_' * 100
    resultado = benchmark(contar_caracteres, cadena)
    assert resultado == len(cadena)

def tesst_benchmark_contar_caracteres_500(benchmark):
    cadena = '_' * 500
    resultado = benchmark(contar_caracteres, cadena)
    assert resultado == len(cadena)
