from ArrayList import ArrayList
from BST import BST
from HashMap import HashMap
from LinkedList import LinkedList

import time
import sys

arraylist = ArrayList(20)

input_1000 = "dataset_1000.txt"

print("RODOU")

with open(input_1000, "r") as archive:
    linhas = archive.readlines()
   
print("LEU")
    
total_time = 0
i = 0
for linha in linhas:
    if i == 0:
        print("ENTROU")
    inicio = time.time()    
    arraylist.add(linha)
    fim = time.time()
    total_time += (fim - inicio)
    print(i)
    i+=1
    
          
total_time = (total_time) / len(linhas)

print(f"tempo total para adicao no arralist {total_time}")