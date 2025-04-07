from ArrayList import ArrayList
from LinkedList import LinkedList
from HashMap import HashMap
from AVL import AVL

import time

#Preenche um array recebendo o size para posterior acesso ao arquivo de input.
def fill_array(size):
    arraylist = ArrayList()
    with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
        lines = archive.readlines()

    for line in lines:
        arraylist.add_last(line)

    return arraylist

def fill_linkedlist(size):
    linkedlist = LinkedList()
    with open(f"../scripts/inputs/dataset_{size}.txt", "r" as archive:
              lines = archive.readlines()

    for line in lines:
              linkedlist.add_last(line)

    return linkedlist

def fill_hashmap(size):
    hashmap = HashMap()
    with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
              lines = archive.readlines()

    for line in lines:
              hashmap.put(line, line)

    return hashmap

def fill_avl(size):
    avl = AVL()
    with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
              lines = archive.readlines()

    for line in lines:
              avl.add(line)

    return avl

#Função que chama as funções individuais de teste de gets.
def test_gets_arraylist():
    outpaths = ["out/arraylist/get_first.txt", "out/arraylist/get_last.txt", "out/arraylist/get_middle.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    get_first_al(outpaths[0], sizes)
    get_last_al(outpaths[1], sizes)
    get_middle_al(outpaths[2], sizes)

#Teste de get first - Arraylist
def get_first_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = ArrayList()
        with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
            lines = archive.readlines()

        for line in lines:
            arraylist.add_last(line)
        
        total_time = 0

        for i in range(30):
            start = time.time()
            arraylist.get_first()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)

        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Teste de get last - Arraylist
def get_last_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = ArrayList()
        with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
            lines = archive.readlines()

        for line in lines:
            arraylist.add_last(line)

        total_time = 0

        for i in range(30):
            start = time.time()
            arraylist.get_last()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)

        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Teste de get middle - Arraylist
def get_middle_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = ArrayList()
        with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
            lines = archive.readlines()

        for line in lines:
            arraylist.add_last(line)

        total_time = 0

        for i in range(30):
            start = time.time()
            arraylist.get_middle()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)

        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Função que chama individualmente as funções de teste de inserção.
def test_insertion_arraylist():
    outpaths = ["out/arraylist/insertion_all.txt", "out/arraylist/insertion_onefirst.txt", "out/arraylist/insertion_onelast.txt", "out/arraylist/insertion_onemiddle", "out/arraylist/insertion_nfirst.txt", "out/arraylist/insertion_nlast.txt", "out/arraylist/insertion_nmiddle.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    insertion_all_al(outpaths[0], sizes)
    insertion_onefirst_al(outpaths[1], sizes)
    insertion_onelast_al(outpaths[2], sizes)
    insertion_onemiddle_al(outpaths[3], sizes)
    insertion_nfirst_al(outpaths[4], sizes)
    insertion_nlast_al(outpaths[5], sizes)
    insertion_nmiddle_al(outpaths[6], sizes)

#Teste de preenchimento do arraylist.
def insertion_all_al(out_path, sizes):
    outputs = []
    for size in sizes:
        arraylist = ArrayList()
        with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
            lines = archive.readlines()

        total_time = 0
        for i in range(30):
            for line in lines:
                start = time.time()
                arraylist.add_last(line)
                end = time.time()
                total_time += (end - start) * 1000

        total_time = (total_time/30)  / size
        outputs.append(f"{size};{total_time} \n")

    with open(out_path, "w") as out:
        out.writelines(outputs)

#Teste de adição de um elemento no início - Arraylist.
def insertion_onefirst_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)
        
        total_time = 0
        for i in range(30):
            start = time.time()
            arraylist.add_first(1)
            end = time.time()
            total_time += (end - start) * 1000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")
    
    with open(outpath, "w") as out:
        out.writelines(outputs)

#Teste de adição de um elemento no final - Arraylist
def insertion_onelast_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)

        total_time = 0
        for i in range(30):
            start = time.time()
            arraylist.add_last(1)
            end = time.time()
            total_time += (end - start) * 1000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Teste de adição de um elemento no meio - Arraylist
def insertion_onemiddle_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)

        total_time = 0
        for i in range(30):
            start = time.time()
            arraylist.add_middle(1)
            end = time.time()
            total_time += (end - start) * 1000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Teste de inserção de n elementos no início - Arraylist
def insertion_nfirst_al(outpath, sizes):
    outputs = []
    for size in sizes:
        n = max(int((size * 0.001)), 1)
        arraylist = fill_array(size)

        total_time = 0
        
        for i in range(30):
            start = time.time()
            for j in range(n):
                arraylist.add_first(1)
            end = time.time()
            total_time += (end - start) * 1000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Teste de inserção de n elementos no final - Arraylist
def insertion_nlast_al(outpath, sizes):
    outputs = []
    for size in sizes:
        n = max(int((size * 0.001)), 1)
        arraylist = fill_array(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            for j in range(n):
                arraylist.add_last(1)
            end = time.time()
            total_time += (end - start) * 1000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Teste de inserção de n elementos no meio - Arraylist
def insertion_nmiddle_al(outpath, sizes):
    outputs = []
    for size in sizes:
        n = max(int((size * 0.001)), 1)
        arraylist = fill_array(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            for j in range(n):
                arraylist.add_middle(1)
            end = time.time()
            total_time += (end - start) * 1000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Função que chama as funções individuais de teste de remoção de arraylist.
def test_remove_arraylist():
    outpaths = ["out/arraylist/remove_onefirst.txt", "out/arraylist/remove_onelast.txt", "out/arraylist/remove_onemiddle.txt", "out/arraylist/remove_nfirst.txt", "out/arraylist/remove_nlast.txt", "out/arraylist/remove_nmiddle.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    remove_onefirst_al(outpaths[0], sizes)
    remove_onelast_al(outpaths[1], sizes)
    remove_onemiddle_al(outpaths[2], sizes)
    remove_nfirst_al(outpaths[3], sizes)
    remove_nlast_al(outpaths[4], sizes)
    remove_nmiddle_al(outpaths[5],sizes)

def remove_onefirst_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)
        
        total_time = 0

        for i in range(30):
            start = time.time()
            arraylist.remove_first()
            end = time.time()
            total_time += (end - start) * 1000

        total_time = (total_time / 30) / size
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_onelast_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            arraylist.remove_last()
            end = time.time()
            total_time += (end - start) * 1000

        total_time = (total_time / 30) / size
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_onemiddle_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            arraylist.remove_middle()
            end = time.time()
            total_time += (end - start) * 1000

        total_time = (total_time / 30) / size
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)


def remove_nfirst_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)
        n = max(int(size * 0.001), 1)
        
        total_time = 0
        for i in range(30):
            start = time.time()
            for j in range(n):
                arraylist.remove_first()
            end = time.time()
            total_time += (end - start) * 1000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

def remove_nlast_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)
        n = max(int(size * 0.001), 1)

        total_time = 0
        for i in range(30):
            start = time.time()
            for j in range(n):
                arraylist.remove_last()
            end = time.time()
            total_time += (end - start) * 1000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

def remove_nmiddle_al(outpath, sizes):
    outputs = []
    for size in sizes:
        arraylist = fill_array(size)
        n = max(int(size * 0.001), 1)

        total_time = 0
        for i in range(30):
            start = time.time()
            for j in range(n):
                arraylist.remove_middle()
            end = time.time()
            total_time += (end - start) * 1000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

def test_gets_linkedlist():
    outpaths = []
    sizes = []
    get_first_ll(outpaths[0], sizes)
    get_last_ll(outpaths[1], sizes)
    get_middle_ll(outpaths[2], sizes)

def test_insertion_linkedlist():
    outpaths = []
    sizes = []
    insertion_all_ll(outpaths[0], sizes)
    insertion_onefirst_ll(outpaths[1], sizes)
    insertion_onelast_ll(outpaths[2], sizes)
    insertion_onemiddle_ll(outpaths[3], sizes)
    insertion_nfirst_ll(outpaths[4], sizes)
    insertion_nlast_ll(outpaths[5], sizes)
    insertion_nmiddle_ll(outpaths[6], sizes)

def test_remove_linkedlist():
    outpaths = []
    sizes = []
    remove_onefirst_ll(outpaths[0], sizes)
    remove_onelast_ll(outpaths[1], sizes)
    remove_onemiddle_ll(outpaths[2], sizes)
    remove_nfirst_ll(outpaths[3], sizes)
    remove_nlast_ll(outpaths[4], sizes)
    remove_nmiddle_ll(outpaths[5], sizes)

test_gets_arraylist()
test_insertion_arraylist()
test_remove_arraylist()
test_gets_linkedlist()
test_insertion_linkedlist()
test_remove_linkedlist()
