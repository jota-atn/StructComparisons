class NodeLinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None

class LinkedList:

    def __init__(self):
        self.first = None
        self.last = None
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return self.first is None

    def add_last(self, value):
        node = NodeLinkedList(value)

        if self.is_empty():
            self.first = node
            self.last = node
        else:
            self.last.next = node
            node.prev = self.last
            self.last = node
        self._size += 1
    
    def add_first(self, value):
       node = NodeLinkedList(value)

       if self.is_empty():
           self.first = node
           self.last = node
       else:
           self.first.prev = node
           node.next = self.first
           self.first = node

       self._size += 1

    def add_middle(self, value):
        middle = len(self) // 2
        self.insert(middle, value)

    def insert(self, index, value):
        node = NodeLinkedList(value)

        if self.is_empty():
            self.first = node
            self.last = node
            self._size += 1
        elif index == 0:
            self.add_first(value)
            return
        elif index > 0:
            aux = self.first
            for i in range(index):
                aux = aux.next
            if aux is None:
                self.add_last(value)
                return
            else:
                node.next = aux
                aux.prev.next = node
                node.prev = aux.prev
                aux.prev = node
                self._size += 1

    def remove(self, index):
        if len(self) == 1:
            self.first = None
            self.last = None
            self._size -= 1
            return

        if index == 0:
            self.first.next.prev = None
            self.first = self.first.next
            self._size -= 1
            return

        if index == len(self) -1:
            self.last.prev.next = None
            self.last = self.last.prev
            self._size -= 1
            return

        else:
            aux = self.first
            for i in range(index):
                aux = aux.next

            aux.next.prev = aux.prev
            aux.prev.next = aux.next
            self._size -= 1

    def remove_last(self):
        removed = self.last
        self.remove(len(self)-1)
        return removed.value

    def remove_first(self):
        removed = self.first
        self.remove(0)
        return removed.value

    def remove_middle(self):
        middle = len(self) // 2
        removed = self.get(middle)
        self.remove(middle)
        return removed
            
    def get(self, index):
        if self.is_empty() or index < 0 or index >= len(self):
            return "Index out of bounds"

        aux = self.first
        cont = 0
        while cont < index:
            aux = aux.next
            cont += 1

        return aux.value

    def get_first(self):
           return self.get(0)

    def get_last(self):
           return self.get(len(self)-1)

    def get_middle(self):
           middle = len(self) // 2
           return self.get(middle)
