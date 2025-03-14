from ArrayList import ArrayList
from BST import BST
from HashMap import HashMap
from LinkedList import LinkedList

import time
import sys

#arraylist = ArrayList(5)
#bst = BST()
#hashmap = HashMap()
#linkedlist = LinkedList()

arraylist = ArrayList(20)

input_1000 = "../scripts/inputs/dataset_1000.txt"
#total_time = 0

with open(input_1000, "r") as archive:
    #for i in range(500):
    total_time = 0
    inicio = time.time()
    for line in archive:
        data = int(line.strip())
        arraylist.add(data)
    fim = time.time()
    total_time += fim - inicio
    #media = total_time / 500
    print(f"ArrayList com inserção de 1000 elementos: {total_time} segundos de execução")

