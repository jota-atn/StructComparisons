from ArrayList import ArrayList
#from LinkedList import LinkedList
#from HashMap import HashMap

import time

def fill_array(size):
    arraylist = ArrayList()
    with open(f"../scripts/inputs/dataset_{size}.txt", "r") as archive:
        lines = archive.readlines()

    for line in lines:
        arraylist.add_last(line)

    return arraylist

def test_gets_arraylist():
    outpaths = ["out/arraylist/get_first.txt", "out/arraylist/get_last.txt", "out/arraylist/get_middle.txt"]
    sizes = [1000, 10000, 100000, 1000000, 10000000]
    get_first_al(outpaths[0], sizes)
    get_last_al(outpaths[1], sizes)
    get_middle_al(outpaths[2], sizes)

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

test_gets_arraylist()
test_insertion_arraylist()
