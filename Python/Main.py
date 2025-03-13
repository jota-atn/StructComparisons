from ArrayList import ArrayList
from BST import BST
from HashMap import HashMap
from LinkedList import LinkedList

arraylist = ArrayList(5)
bst = BST()
hashmap = HashMap()
linkedlist = LinkedList()

arraylist.add(8)
assert len(arraylist) == 1
arraylist.remove()
assert len(arraylist) == 0
arraylist.add(1)
arraylist.add(2)
arraylist.add(3)
arraylist.add(4)
assert arraylist.get(0) == 1
assert arraylist.get(1) == 2
assert arraylist.get(2) == 3
assert arraylist.get(3) == 4
assert len(arraylist) == 4

print('---' + '\n' + '---' + '\n' + '---')
       
linkedlist.add(1)
assert len(linkedlist) == 1
linkedlist.remove()
assert len(linkedlist) == 0
linkedlist.add(1)
linkedlist.add(2)
linkedlist.add(3)
linkedlist.add(4)
assert linkedlist.get(0) == 1
assert linkedlist.get(1) == 2
assert linkedlist.get(2) == 3
assert linkedlist.get(3) == 4
assert len(linkedlist) == 4

print('---' + '\n' + '---' + '\n' + '---')

hashmap.put(1234, 1)
assert len(hashmap) == 1
hashmap.remove(1234)
assert len(hashmap) == 0
hashmap.put(12345, 25)
hashmap.put(12345, 35)
assert len(hashmap) == 1
assert hashmap.get(12345) == 35

print('---' + '\n' + '---' + '\n' + '---')

bst.add(89)
assert len(bst) == 1
bst.add(3)
assert len(bst) == 2