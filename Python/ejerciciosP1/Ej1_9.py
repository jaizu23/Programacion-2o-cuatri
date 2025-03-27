def sumatorio(num: int) -> int:
    """O(n)"""
    if num <= 0:
        return -1
    if num == 1:
        return 1
    return num + sumatorio(num - 1)


print(sumatorio(10))
##############################
#          TESTS             #
##############################

def test_comprobar_sumatorio_20(benchmark):
    resultado = benchmark(sumatorio,20)
    assert resultado == 210

def test_comprobar_sumatorio_10(benchmark):
    resultado = benchmark(sumatorio,10)
    assert resultado == 55

def test_casos_limite_1():
    resultado = sumatorio(-6)
    assert resultado == -1

def test_casos_limite_2():
    resultado = sumatorio(0)
    assert resultado == -1

def test_casos_limite_3():
    resultado = sumatorio(6)
    assert resultado == 21