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