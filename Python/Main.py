from ArrayList import ArrayList
from BST import BST
from HashMap import HashMap

import time
import sys

arraylist = ArrayList(20)

sizes = [1000, 10000, 100000, 1000000, 10000000]

for size in sizes:
    with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
        linhas = archive.readlines()
    
    total_time = 0

    for linha in linhas:
        inicio = time.perf_counter()    
        arraylist.add(linha)
        fim = time.perf_counter()
        total_time += (fim - inicio) * 1000
            
    total_time = (total_time) / len(linhas)

    print(f"{size};{total_time}")
