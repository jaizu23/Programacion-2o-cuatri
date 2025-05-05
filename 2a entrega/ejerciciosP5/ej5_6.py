def reduce_palabra(palabra: str, tabla_sustitucion: dict[dict[str]], pasos: list[str]) -> str:
    """
    Reduce la palabra dada a una sola letra si es posible, sustituyendo pares de letras consecutivos
    por el valor devuelto por la tabla de sustitución, de forma que la primera letra de cada par
    representa la fila de la tabla y la segunda letra representa la columna.
    Si no es posible reducir la palabra a una letra, devuelve None.
    """

    pasos[len(palabra) - 1] = palabra

    if len(palabra) <= 1:
        return palabra
    
    resultado = None
    for i in range(len(palabra) - 1):
        if (tabla_sustitucion.get(palabra[i]) == None):
            continue
        elif (tabla_sustitucion.get(palabra[i]).get(palabra[i+1]) == None):
            continue

        nueva_palabra = palabra[:i] + tabla_sustitucion.get(palabra[i]).get(palabra[i+1]) + palabra[i+2:]
        
        resultado = reduce_palabra(nueva_palabra, tabla_sustitucion, pasos)
        if resultado != None:
            return resultado

    return resultado
        
palabra = "acabada"
tabla_sustitucion = {
    "a": {
        "a": "b",
        "b": "b",
        "c": "a",
        "d": "d",
    },
    "b": {
        "a": "c",
        "b": "a",
        "c": "d",
        "d": "a",
    },
    "c": {
        "a": "b",
        "b": "a",
        "c": "c",
        "d": "c",
    },
    "d": {
        "a": "d",
        "b": "c",
        "c": "b",
        "d": "b",
    }
}   

# Test simple de uso
pasos = [None] * (len(palabra))
print(reduce_palabra(palabra, tabla_sustitucion, pasos))

##############################
#          TESTS             #
##############################

def test_caso_dificil1 (benchmark):
    palabra_dificil = "abacbaccbac"
    tabla_dificil = {
        "a": {
            "a": "b",
            "b": None,
            "c": "a",
        },
        "b": {
            "a": "a",
            "b": None,
            "c": None,
        },
        "c": {
            "a": None,
            "b": "a",
            "c": None,
        }
    }
    pasos = [None] * (len(palabra_dificil))
    resultado = benchmark(reduce_palabra(palabra_dificil, tabla_dificil, pasos))
    print(f"Return: {resultado}")
    pasos.reverse()
    for i, paso in enumerate(pasos):
        print(f"Paso {i}: {paso}")

    assert resultado == "a", "El resultado no es el esperado (a)"
    assert pasos == ["abacbaccbac", "abacbacbac", "abacbac", "abacb", "ab", "a"], "Los pasos no son los esperados (['abacbaccbac', 'abacbacbac', 'abacbac', 'abacb', 'ab', 'a'])"


def test_caso_dificil2 (benchmark):
    palabra_dificil = "adcbedbdceba"
    tabla_dificil = {
        "a": {
            "a": "b",
            "b": None,
            "c": "e",
            "d": None,
            "e": "a",
        },
        "b": {
            "a": None,
            "b": "d",
            "c": None,
            "d": "c",
            "e": None,
        },
        "c": {
            "a": None,
            "b": "a",
            "c": None,
            "d": None,
            "e": "b",
        },
        "d": {
            "a": None,
            "b": "e",
            "c": None,
            "d": None,
            "e": None,
        },
        "e": {
            "a": None,
            "b": "c",
            "c": None,
            "d": "e",
            "e": None,
        }
    }
    pasos = [None] * (len(palabra_dificil))
    resultado = benchmark(reduce_palabra(palabra_dificil, tabla_dificil, pasos))
    print(f"Return: {resultado}")
    pasos.reverse()
    for i, paso in enumerate(pasos):
        print(f"Paso {i}: {paso}")

    assert resultado == "a", "El resultado no es el esperado (a)"
    assert pasos == ["adcbedbdceba", "adcbedbdcba", "adcbedbca", "adcbedb", "adcb", "a"], "Los pasos no son los esperados (['adcbedbdceba', 'adcbedbdcba', 'adcbedbca', 'adcbedb', 'adcb', 'a'])"