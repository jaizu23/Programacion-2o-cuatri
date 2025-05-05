def rango(min, max, inc):
    num = min
    while num < max:
        yield num
        num += inc

def random_sequence(min, max, n):
    import random
    while n > 0:
        yield random.randint(min, max)
        n -= 1

for num in random_sequence(1, 20, 10):
    print(num)

lista_aleatoria = list(random_sequence(1, 20, 10))
print(lista_aleatoria)
