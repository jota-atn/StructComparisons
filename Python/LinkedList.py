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

    def add(self, value):
        node = NodeLinkedList(value)

        if self.is_empty():
            self.first = node
        self.last.next = node
        node.prev = self.last
        self.last = node
        self._size += 1

    def remove(self):
        removed = self.last

        if len(self) == 1:
            self.first = None
            self.last = None
        else:
            self.last.prev.next = None
            self.last = self.last.prev
        self._size -= 1
        return removed.value

    def get(self, index):
        if self.is_empty() or index < 0 or index >= len(self):
            return "Index out of bounds"

        aux = self.first
        for i in range(index - 1):
            aux = aux.next

        return aux.value