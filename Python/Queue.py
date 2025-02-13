from Node import Node

class Queue:
    
    def __init__(self):
        self.first = None
        self.last = None
        self._size = 0


    def __len__(self):
        return self._size

    def __repr__(self):
        if self.empty():
            return 'Fila vazia!'
        output = ''
        node = self.first
        while(node):
            output += str(node.data) + ' '
            node = node.next
        return output.strip()

    def empty(self):
        return len(self) == 0

    def peek(self):
        if self.empty():
            return 'Fila vazia!'
        return self.first.data

    def push(self, data):
        node = Node(data)

        if self.last is None:
            self.last = node
        else:
            self.last.next = node
            self.last = node
        if self.first is None:
            self.first = node
        self._size += 1


    def pop(self):
        if self.empty():
            return 'Pilha vazia!'
        removed = self.first
        self.first = self.first.next
        self._size -= 1
        return removed.data
