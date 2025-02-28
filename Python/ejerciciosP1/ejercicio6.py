
def esPerfecto(num: int) -> bool:
    """O(n)"""
    i = 1
    div = []
    def sumaLista(lista: list) -> int:
        sum = 0
        for i in lista:
            sum += i
        return sum
    if num < 0:
        return False
    while i < num:
        if num % i == 0:
            div.append(i)
        i += 1
    return sumaLista(div) == num

##############################
#          TESTS             
##############################

def test_comprobar_perfecto_8128(benchmark):
    resultado = benchmark(esPerfecto,8128)
    assert resultado == True

def test_comprobar_perfecto_1000(benchmark):
    resultado = benchmark(esPerfecto,1000)
    assert resultado == False

def test_casos_limite_1():
    resultado = esPerfecto(-6)
    assert resultado == False

def test_casos_limite_2():
    resultado = esPerfecto(0)
    assert resultado == True

def test_casos_limite_3():
    resultado = esPerfecto(6)
    assert resultado == True
