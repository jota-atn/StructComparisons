class ArrayList:

    def __init__(self, size):
        self.array = [None for i in range(size)]
        self.last = None
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return len(self) == 0

    def add(self, valor):
        self.ensure_capacity(len(self.array) + 1)
        if self.is_empty():
            self.last = 0

        self.array[self.last] = valor
        self.last += 1
        self._size += 1

    def remove(self):
        removed = self.array[self.last]
        if len(self) == 1:
            self.last = None
        else:
            self.last -= 1
        self._size -= 1
        return removed

    def get(self, index):
        if self.is_empty() or index < 0 or index >= len(self):
            return "Index out of bounds"

        return self.array[index]

    def resize(self):
        aux = [None for i in range(len(self.array) * 2)]
        for i in range(len(self.array)):
            aux[i] = self.array[i]
        self.array = aux

    def ensure_capacity(self, capacidade_pretendida):
        if capacidade_pretendida > len(self.array):
            self.resize()