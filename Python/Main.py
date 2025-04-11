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
    with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
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
    outpaths = ["out/arraylist/get_first.txt", "out/arraylist/get_last.txt", "out/arraylist/get_mid.txt"]
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
    outpaths = ["out/arraylist/insertion_all.txt", "out/arraylist/insertion_first_one_element.txt", "out/arraylist/insertion_last_one_element.txt", "out/arraylist/insertion_mid_one_element.txt", "out/arraylist/insertion_first_n_elements.txt", "out/arraylist/insertion_last_n_elements.txt", "out/arraylist/insertion_mid_n_elements.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000]
    #insertion_all_al(outpaths[0], sizes)
    insertion_onefirst_al(outpaths[1], sizes)
    #insertion_onelast_al(outpaths[2], sizes)
    #insertion_onemiddle_al(outpaths[3], sizes)
    #insertion_nfirst_al(outpaths[4], sizes)
    #insertion_nlast_al(outpaths[5], sizes)
    #insertion_nmiddle_al(outpaths[6], sizes)

#Teste de preenchimento do arraylist.
def insertion_all_al(outpath, sizes):
    outputs = []
    for size in sizes:
        with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
            lines = archive.readlines()

        total_time = 0
        for i in range(30):
            arraylist = ArrayList()
            start = time.time()
            for line in lines:
                arraylist.add_last(line)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
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
            total_time += (end - start) * 1000000000

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
            total_time += (end - start) * 1000000000

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
            total_time += (end - start) * 1000000000

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
            total_time += (end - start) * 1000000000

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
            total_time += (end - start) * 1000000000

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
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#Função que chama as funções individuais de teste de remoção de arraylist.
def test_remove_arraylist():
    outpaths = ["out/arraylist/remove_first_one_element.txt", "out/arraylist/remove_last_one_element.txt", "out/arraylist/remove_mid_one_element.txt", "out/arraylist/remove_first_n_elements.txt", "out/arraylist/remove_last_n_elements.txt", "out/arraylist/remove_mid_n_elements.txt"]
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
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
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
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
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
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
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
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

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
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)


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
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def test_gets_linkedlist():
    outpaths = ["out/linkedlist/get_first.txt", "out/linkedlist/get_last.txt", "out/linkedlist/get_mid.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    get_first_ll(outpaths[0], sizes)
    get_last_ll(outpaths[1], sizes)
    get_middle_ll(outpaths[2], sizes)

def get_first_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)
        total_time = 0

        for i in range(30):
            start = time.time()
            linkedlist.get_first()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)

        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def get_last_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)
        total_time = 0

        for i in range(30):
            start = time.time()
            linkedlist.get_last()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)

        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def get_middle_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)
        total_time = 0

        for i in range(30):
            start = time.time()
            linkedlist.get_middle()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)

        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def test_insertion_linkedlist():
    outpaths = ["out/linkedlist/insertion_all.txt", "out/linkedlist/insertion_first_one_element.txt", "out/linkedlist/insertion_last_one_element.txt", "out/linkedlist/insertion_mid_one_element.txt", "out/linkedlist/insertion_first_n_elements.txt", "out/linkedlist/insertion_last_n_elements.txt", "out/linkedlist/insertion_mid_n_elements.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    insertion_all_ll(outpaths[0], sizes)
    insertion_onefirst_ll(outpaths[1], sizes)
    insertion_onelast_ll(outpaths[2], sizes)
    insertion_onemiddle_ll(outpaths[3], sizes)
    insertion_nfirst_ll(outpaths[4], sizes)
    insertion_nlast_ll(outpaths[5], sizes)
    insertion_nmiddle_ll(outpaths[6], sizes)

def insertion_all_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
            lines = archive.readlines()

        total_time = 0
        for i in range(30):
            linkedlist = LinkedList()
            start = time.time()
            for line in lines:
                linkedlist.add_last(line)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def insertion_onefirst_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)

        total_time = 0
        for i in range(30):
            start = time.time()
            linkedlist.add_first(1)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def insertion_onelast_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)

        total_time = 0
        for i in range(30):
            start = time.time()
            linkedlist.add_last(1)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)


def insertion_onemiddle_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)

        total_time = 0
        for i in range(30):
            start = time.time()
            linkedlist.add_middle(1)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def insertion_nfirst_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        n = max(int((size * 0.001)), 1)
        linkedlist = fill_linkedlist(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            for j in range(n):
                linkedlist.add_first(1)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def insertion_nlast_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        n = max(int((size * 0.001)), 1)
        linkedlist = fill_linkedlist(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            for j in range(n):
                linkedlist.add_last(1)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def insertion_nmiddle_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        n = max(int((size * 0.001)), 1)
        linkedlist = fill_linkedlist(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            for j in range(n):
                linkedlist.add_middle(1)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def test_remove_linkedlist():
    outpaths = ["out/linkedlist/remove_first_one_element.txt", "out/linkedlist/remove_last_one_element.txt", "out/linkedlist/remove_mid_one_element.txt", "out/linkedlist/remove_first_n_elements.txt", "out/linkedlist/remove_last_n_elements.txt", "out/linkedlist/remove_mid_n_elements.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    remove_onefirst_ll(outpaths[0], sizes)
    remove_onelast_ll(outpaths[1], sizes)
    remove_onemiddle_ll(outpaths[2], sizes)
    remove_nfirst_ll(outpaths[3], sizes)
    remove_nlast_ll(outpaths[4], sizes)
    remove_nmiddle_ll(outpaths[5], sizes)

def remove_onefirst_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            linkedlist.remove_first()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_onelast_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            linkedlist.remove_last()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_onemiddle_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)

        total_time = 0

        for i in range(30):
            start = time.time()
            linkedlist.remove_middle()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time = (total_time / 30)
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_nfirst_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)
        n = max(int(size * 0.001), 1)

        total_time = 0
        for i in range(30):
            start = time.time()
            for j in range(n):
                linkedlist.remove_first()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_nlast_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)
        n = max(int(size * 0.001), 1)

        total_time = 0
        for i in range(30):
            start = time.time()
            for j in range(n):
                linkedlist.remove_last()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_nmiddle_ll(outpath, sizes):
    outputs = []
    for size in sizes:
        linkedlist = fill_linkedlist(size)
        n = max(int(size * 0.001), 1)

        total_time = 0
        for i in range(30):
            start = time.time()
            for j in range(n):
                linkedlist.remove_middle()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def test_hashmap():
    outpaths = ["out/hashmap/insertion_all.txt", "out/hashmap/acess_one_element.txt", "out/hashmap/remove_one_element.txt", "out/hashmap/search_innexistent.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    insertion_all_hash(outpaths[0], sizes)
    acess_one(outpaths[1], sizes)
    remove_one(outpaths[2], sizes)
    search_zero(outpaths[3], sizes)

def insertion_all_hash(outpath, sizes):
    outputs = []
    for size in sizes:

        with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
            lines = archive.readlines()

        total_time = 0

        for i in range(30):
            hashmap = HashMap()
            start = time.time()
            for line in lines:
                hashmap.put(line, line)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def acess_one(outpath, sizes):
    outputs = []
    for size in sizes:
        targetkey = size // 2
        hashmap = fill_hashmap(size)
        total_time = 0
        start = time.time()
        for i in range(30):
            hashmap.get(targetkey)
        end = time.time()
        total_time += ((end - start) * 1000000000) / 30

        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_one(outpath, sizes):
    outputs = []
    for size in sizes:
        hashmap = fill_hashmap(size)
        targetkey = size // 2
        total_time = 0
        for i in range(30):
            start = time.time()
            hashmap.remove(targetkey)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def search_zero(outpath, sizes):
    outputs = []
    for size in sizes:
        hashmap = fill_hashmap(size)
        total_time = 0
        start = time.time()
        for i in range(30):
            hashmap.get(1000000000)
        end = time.time()
        total_time += ((end - start) * 1000000000) / 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def test_avl():
    outpaths = ["out/avltree/insertion_all.txt", "out/avltree/search.txt", "out/avltree/remove.txt", "out/avltree/max.txt", "out/avltree/min.txt", "out/avltree/sucessor.txt", "out/avltree/predecessor.txt"]
    sizes = [1000, 10000, 100000, 250000, 500000, 600000, 750000, 1000000, 1700000, 2500000, 3700000, 5000000, 6000000, 7500000, 9000000, 10000000]
    insertion_all_avl(outpaths[0], sizes)
    search_avl(outpaths[1], sizes)
    remove_avl(outpaths[2], sizes)
    max_avl(outpaths[3], sizes)
    min_avl(outpaths[4], sizes)
    sucessor_avl(outpaths[5], sizes)
    predecessor_avl(outpaths[6], sizes)

def insertion_all_avl(outpath, sizes):
    outputs = []
    for size in sizes:
        with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
            lines = archive.readlines()

        total_time = 0

        for i in range(30):
            avl = AVL()
            start = time.time()
            for line in lines:
                avl.add(line)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def search_avl(outpath, sizes):
    outputs = []
    for size in sizes:
        target = 1000000000
        avl = fill_avl(size)
        total_time = 0
        start = time.time()
        for i in range(30):
            avl.search(target)
        end = time.time()
        total_time += ((end - start) * 1000000000) / 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def remove_avl(outpath, sizes):
    outputs = []
    for size in sizes:
        target = size // 2
        total_time = 0
        for i in range(30):
            avl = fill_avl(size)
            start = time.time()
            avl.remove(target)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def max_avl(outpath, sizes):
    outputs = []
    for size in sizes:
        total_time = 0
        avl = fill_avl(size)
        for i in range(30):
            start = time.time()
            avl.max()
            end = time.time()
            total_time += (end-start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def min_avl(outpath, sizes):
    outputs = []
    for size in sizes:
        total_time = 0
        avl = fill_avl(size)
        for i in range(30):
            start = time.time()
            avl.min()
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def sucessor_avl(outpath, sizes):
    outputs = []
    for size in sizes:
        total_time = 0
        avl = fill_avl(size)
        target = size // 2
        for i in range(30):
            start = time.time()
            avl.sucessor(target)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

def predecessor_avl(outpath, sizes):
    outputs = []
    for size in sizes:
        total_time = 0
        avl = fill_avl(size)
        target = size // 2
        for i in range(30):
            start = time.time()
            avl.predecessor(target)
            end = time.time()
            total_time += (end - start) * 1000000000

        total_time /= 30
        outputs.append(f"{size};{total_time} \n")

    with open(outpath, "w") as out:
        out.writelines(outputs)

#test_gets_arraylist()
test_insertion_arraylist()
test_remove_arraylist()
test_gets_linkedlist()
test_insertion_linkedlist()
test_remove_linkedlist()
test_hashmap()
test_avl()