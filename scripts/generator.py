import random
import os

def generate_large_data(filename: str, size: int, mode="random", num_range=(0, 1000000), guaranteed_elements=None):
    """
    Gera um arquivo de teste contendo apenas números inteiros aleatórios, com elementos garantidos.
    :param filename: Nome do arquivo a ser gerado.
    :param size: Quantidade total de números.
    :param mode: "random" (aleatório), "sorted" (ordenado), "reversed" (invertido).
    :param num_range: Intervalo (mínimo, máximo) dos números gerados.
    :param guaranteed_elements: Lista de elementos que devem estar no dataset.
    """
    if guaranteed_elements is None:
        guaranteed_elements = []

    count_random = size - len(guaranteed_elements)
    numbers = [random.randint(num_range[0], num_range[1]) for _ in range(count_random)]
    
    for elem in guaranteed_elements:
        insert_index = random.randint(0, len(numbers))
        numbers.insert(insert_index, elem)

    if mode == "sorted":
        numbers.sort()
    elif mode == "reversed":
        numbers.sort(reverse=True)

    with open(filename, "w") as f:
        for num in numbers:
            f.write(f"{num}\n")

    print(f"Arquivo gerado com os elementos garantidos: {guaranteed_elements}")

if __name__ == "__main__":
    os.makedirs("inputs", exist_ok=True)

    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    
    for size in sizes:
        filename = f"inputs/dataset_{size}.txt"
        
        element = 1000

        generate_large_data(filename, size, "random", (0, 1000000), guaranteed_elements=[element])
        print(f"Elemento garantido no dataset_{size}: {element}")
