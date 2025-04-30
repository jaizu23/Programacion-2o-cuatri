##############################
#        BIBLIOTECA          #
##############################

def hanoi(n: int):
    def _hanoi(n: int, A: str, B: str, C: str, mov: int):
        if n == 1:
            print(f"Mover disco de {A} a {C}")
            return 1
        else:
            mov1 = _hanoi(n-1, A, C, B, mov+1)
            print(f"Mover disco de {A} a {C}")
            mov2 = _hanoi(n-1, B, A, C, mov+1)
            return mov1 + 1 + mov2
    return _hanoi(n, 'A', 'B', 'C', 0)







##############################
#          TESTS             #
##############################

def tesst_hanoi_3(benchmark):
    resultado = benchmark(hanoi, 3)
    assert True

def tesst_hanoi_10(benchmark):
    resultado = benchmark(hanoi, 10)
    assert True

def tesst_hanoi_20(benchmark):
    resultado = benchmark(hanoi, 20)
    assert True

def tesst_hanoi_50(benchmark):
    resultado = benchmark(hanoi, 50)
    assert True

