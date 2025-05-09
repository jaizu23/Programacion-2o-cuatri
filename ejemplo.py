
import string

def es_solucion(pwd: str) -> bool:
    return pwd == "hola"


def pwdcrack(max_len: int, pwd: str = "", nivel: int = 0) -> bool:
    if nivel == max_len:
        if es_solucion(pwd):
            print(f"Password found: {pwd}")
            return True
        else:
            print(pwd)
            return False
        
    letras = string.ascii_lowercase + string.digits
    salir = False
    pos = 0
    while pos < len(letras) and not salir:
        pwd += letras[pos]
        salir = pwdcrack(max_len, pwd, nivel + 1)
        pwd = pwd[:-1] # Backtrack
        pos += 1
    return salir

pwdcrack(4, "", 0)