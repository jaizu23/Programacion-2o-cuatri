from Python.ejerciciosP1.Ej5 import esPrimo

def test_comprobar_primo_1000(benchmark):
    resultado = benchmark(esPrimo,1000)
    assert resultado == False

def test_comprobar_primo_3863(benchmark):
    resultado = benchmark(esPrimo,3863)
    assert resultado == True

def test_casos_limite_1():
    resultado = esPrimo(-1)
    assert resultado == False

def test_casos_limite_2():
    resultado = esPrimo(0)
    assert resultado == False

def test_casos_limite_3():
    resultado = esPrimo(2)
    assert resultado == True