def numeros_posibles (numero: str, cifras: int) -> set[str]:
    """
    Devuelve una lista con todos los posibles números de 'cifras' cifras que se pueden formar
    con combinaciones de los dígitos del número dado manteniendo el orden del número original.
    """
    if cifras > len(numero) or cifras <= 0 or len(numero) == 0:
        return set()
    elif cifras == 1:
        return set(numero)

    resultado = set() # Usamos un set para evitar que se repitan números
    for i, digito in enumerate(numero):
        sub_resultados = numeros_posibles(numero[i + 1:], cifras - 1)
        for sub_resultado in sub_resultados:
            resultado.add(digito + sub_resultado)

    return resultado

numero = "115124"
cifras = 4

print(numeros_posibles(numero, cifras))