class ArrayList:
    def __init__(self, size):
        self.array = [None for i in range(size)]
        self.last = None
        self._size = 0

    def __len__(self):
        return this._size

    def isEmpty(self):
        return len(self) == 0

    def append(self, valor):
        if self.isEmpty():


