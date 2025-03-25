from math import sqrt

def esPrimo (num: int) -> bool:
    """O(sqrt(n))"""
    i = 2
    if num <= 0:
        return False
    while i <= sqrt(num):
        if num % i == 0:
            return False
        i+=1
    return True

##############################
#          TESTS             #
##############################

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