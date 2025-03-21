from ArrayList import ArrayList
from BST import BST
from HashMap import HashMap
from LinkedList import LinkedList

import time
import sys

arraylist = ArrayList(20)

sizes = [1000, 10000, 100000, 1000000, 10000000]

for size in sizes:
    with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
        linhas = archive.readlines()
    
    total_time = 0

    for linha in linhas:
        inicio = time.time()    
        arraylist.add(linha)
        fim = time.time()
        total_time += (fim - inicio)
        
            
    total_time = (total_time) / len(linhas)

    print(f"{size};{total_time}")
