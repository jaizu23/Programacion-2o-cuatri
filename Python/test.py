lista = ().__class__.__subclasses__()

for i, elemento in enumerate(lista):
    if 'ex' in elemento.__name__:
        print(i)        