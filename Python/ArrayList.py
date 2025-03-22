class ArrayList:

    def __init__(self, size):
        self.array = []
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return len(self) == 0

    def add(self, valor):
        self.array.append(valor)
        self._size += 1
    
    def add_first(self, valor):
        self.array.insert(0, valor)
        self._size += 1

    def remove(self):
        removed = self.array[-1]
        self.array.pop()
        self._size -= 1
        return removed

    def insert(self, index, valor):
        if index < 0 or index >= len(self):
            return 'index out of bounds'

        self.array.insert(index, valor)
        self._size += 1
    
    def insert_middle(self, valor):
        insert(len(self), valor)

    def remove_first(self):
        removed = self.array[0]
        self.array.pop(0)
        self._size -= 1
        return removed

    def get(self, index):
        if self.is_empty() or index < 0 or index >= len(self):
            return "Index out of bounds"

        return self.array[index]
