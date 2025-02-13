from Node import Node


class Stack:
    def __init__(self):
        self.top = None
        self._size = 0

    def __len__(self):
        return self._size

    def __repr__(self):
        if self.empty():
            return 'Pilha vazia!'
        output = ''
        node = self.top
        while(node):
            output += str(node.data) + '\n'
            node = node.next
        return output.strip()


    def empty(self):
        return len(self) == 0

    def peek(self):
        if self.empty():
            return 'Pilha vazia!'
        return self.top.data

    def push(self, data):
        node = Node(data)
        node.next = self.top
        self.top = node
        self._size += 1

    def pop(self):
        if self.empty():
            return 'Pilha vazia!'
        removed = self.top
        self.top = self.top.next
        self._size -= 1
        return removed.data
