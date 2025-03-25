
def sumatorio(num: int) -> int:
    """O(n)"""
    if num <= 0:
        return -1
    if num == 1:
        return 1
    return num + sumatorio(num - 1)




##############################
#          TESTS             #
##############################

def test_comprobar_sumatorio_10000(benchmark):
    resultado = benchmark(sumatorio,10000)
    assert resultado == 50005000
 
def test_comprobar_sumatorio_2000(benchmark):
    resultado = benchmark(sumatorio,2000)
    assert resultado == 2001000

def test_casos_limite_1():
    resultado = sumatorio(-6)
    assert resultado == -1

def test_casos_limite_2():
    resultado = sumatorio(0)
    assert resultado == -1

def test_casos_limite_3():
    resultado = sumatorio(6)
    assert resultado == 21
