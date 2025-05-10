# Algoritmia y Complejidad Curso 2024-25
# Esqueleto de trabajo en Python

import sys

def main(args :list[str]) -> None:
    """ 
        Programa principal, sys.argv debe contener al menos un elemento a procesar
        consultar https://docs.python.org/3/library/sys.html#sys.argv
    """

    print('Programa de lectura de ficheros')
    if len(args) > 1: # Tiene al menos 2 argumentos
        ruta_fichero = args[1]
        with open(ruta_fichero, 'r') as fichero: # Abrir el fichero en modo lectura
            print(f'El fichero {ruta_fichero}')
    else:
        print('No hay fichero que procesar')    


if __name__ == '__main__': # Si este modulo es el principal
    if '--test' in sys.argv: # Si existe "--test" en la linea de argumentos
        import pytest
        import glob
        pytest.main( sys.argv[2:] + # Le pasamos el resto de argumentos (launch.json)
            glob.glob("**/ejerciciosP4/*.py", recursive=True) +
            glob.glob("**/ejerciciosP5/*.py", recursive=True)) # Ruta de los archivos para buscar los tests
    else:
        main(sys.argv) # Ejecutamos el programa principal
