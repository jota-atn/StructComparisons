class HashMap:

    def __init__(self):
        self.hashmap = {}
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return len(self) == 0

    def put(self, key, value):
        if key in self.hashmap:
            if value != self.hashmap[key]:
                self.hashmap[key] = value
        else:
            self.hashmap[key] = value
            self._size += 1

    def remove(self, key):
        if self.is_empty():
            return 'Empty HashMap!'

        if key not in self.hashmap: return

        removed = self.hashmap[key]
        self.hashmap.pop(self, key)
        self._size -= 1

        return removed

    def get(self, key):
        if self.is_empty():
            return 'Empty HashMap!'
        if key not in self.hashmap:
            return 'Key not found'
        else:
            return self.hashmap[key]

    def contains_key(self, key):
        return key in self.hashmap

    def contains_value(self, value):
        for key in self.hashmap:
            if self.hashmap[key] == value: return True
        return False
