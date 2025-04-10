import random
import os

def generate_large_data(filename: str, size: int, mode="random", num_range=(0, 1000000)):
    """
    Gera um arquivo de teste contendo apenas números inteiros aleatórios.
    :param filename: Nome do arquivo a ser gerado.
    :param size: Quantidade total de números.
    :param mode: "random" (aleatório), "sorted" (ordenado), "reversed" (invertido).
    :param num_range: Intervalo (mínimo, máximo) dos números gerados.
    """
    numbers = [random.randint(num_range[0], num_range[1]) for _ in range(size)]
    
    if mode == "sorted":
        numbers.sort()
    elif mode == "reversed":
        numbers.sort(reverse=True)
    
    with open(filename, "w") as f:
        for num in numbers:
            f.write(f"{num}\n")

if __name__ == "__main__":
    os.makedirs("inputs", exist_ok=True)
    
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]

    for size in sizes:
        filename = f"inputs/dataset_{size}.txt"
        generate_large_data(filename, size, "random", (0, 1000000))
        print(f"Arquivo de teste gerado: {filename}")

