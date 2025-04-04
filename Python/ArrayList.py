class ArrayList:

    def __init__(self):
        self.array = []
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return len(self) == 0

    def add_last(self, valor):
        self.array.append(valor)
        self._size += 1
    
    def add_first(self, valor):
        self.array.insert(0, valor)
        self._size += 1

    def add_middle(self, valor):
        middle = len(self) // 2
        self.array.insert(middle, valor)
        self._size += 1

    def remove_first(self):
        removed = self.array[-1]
        self.array.pop()
        self._size -= 1
        return removed

    def remove_middle(self):
        middle = len(self) // 2
        removed = self.array[middle]
        self.array.pop(middle)
        self._size -= 1
        return removed

    def remove_last(self):
        removed = self.array[-1]
        self.array.pop()
        self._size -= 1
        return removed

    def search(self, value):
        for i in range(len(self)):
            if self.array[i] == value:
                return i
        return -1

    def get_first(self):
        return self.get(0)

    def get_middle(self):
        middle = len(self) // 2
        return self.get(middle)

    def get_last(self):
        return self.get(len(self)-1)

    def get(self, index):
        if self.is_empty() or index < 0 or index >= len(self):
            return "Index out of bounds"

        return self.array[index]
