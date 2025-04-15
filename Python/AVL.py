class Node:
    def __init__(self, value, parent=None):
        self.value = value
        self.left = None
        self.right = None
        self.parent = parent
        self.height = 1

class AVL:
    def __init__(self):
        self.root = None

    def _height(self, node):
        return node.height if node else 0

    def _balance_factor(self, node):
        return self._height(node.left) - self._height(node.right)

    def _update_height(self, node):
        node.height = 1 + max(self._height(node.left), self._height(node.right))

    def _rotate_right(self, y):
        x = y.left
        T2 = x.right

        x.right = y
        y.left = T2

        x.parent = y.parent
        y.parent = x
        if T2:
            T2.parent = y

        self._update_height(y)
        self._update_height(x)

        return x

    def _rotate_left(self, x):
        y = x.right
        T2 = y.left

        y.left = x
        x.right = T2

        y.parent = x.parent
        x.parent = y
        if T2:
            T2.parent = x

        self._update_height(x)
        self._update_height(y)

        return y

    def _balance(self, node):
        self._update_height(node)
        balance = self._balance_factor(node)

        if balance > 1:
            if self._balance_factor(node.left) < 0:
                node.left = self._rotate_left(node.left)
                node.left.parent = node
            return self._rotate_right(node)

        if balance < -1:
            if self._balance_factor(node.right) > 0:
                node.right = self._rotate_right(node.right)
                node.right.parent = node
            return self._rotate_left(node)

        return node

    def _add(self, node, value, parent=None):
        if not node:
            return Node(value, parent)
        elif value < node.value:
            node.left = self._add(node.left, value, node)
        elif value > node.value:
            node.right = self._add(node.right, value, node)
        else:
            return node
        return self._balance(node)

    def add(self, value):
        self.root = self._add(self.root, value)
        if self.root:
            self.root.parent = None

    def _min_node(self, node):
        while node.left:
            node = node.left
        return node

    def _remove(self, node, value):
        if not node:
            return None
        elif value < node.value:
            node.left = self._remove(node.left, value)
            if node.left:
                node.left.parent = node
        elif value > node.value:
            node.right = self._remove(node.right, value)
            if node.right:
                node.right.parent = node
        else:
            if not node.left:
                if node.right:
                    node.right.parent = node.parent
                return node.right
            elif not node.right:
                if node.left:
                    node.left.parent = node.parent
                return node.left

            temp = self._min_node(node.right)
            node.value = temp.value
            node.right = self._remove(node.right, temp.value)
            if node.right:
                node.right.parent = node

        return self._balance(node)

    def remove(self, value):
        self.root = self._remove(self.root, value)
        if self.root:
            self.root.parent = None

    def _search(self, node, value):
        if not node or node.value == value:
            return node
        elif value < node.value:
            return self._search(node.left, value)
        else:
            return self._search(node.right, value)

    def search(self, value):
        return self._search(self.root, value) is not None

    def min(self):
        if not self.root:
            return None
        return self._min_node(self.root).value

    def max(self):
        if not self.root:
            return None
        node = self.root
        while node.right:
            node = node.right
        return node.value

    def predecessor(self, value):
        node = self._search(self.root, value)
        if not node:
            return None
        if node.left:
            return self._min_node(node.left).value
        parent = node.parent
        while parent and node == parent.left:
            node = parent
            parent = parent.parent
        return parent.value if parent else None

    def sucessor(self, value):
        node = self._search(self.root, value)
        if not node:
            return None
        if node.right:
            return self._min_node(node.right).value
        parent = node.parent
        while parent and node == parent.right:
            node = parent
            parent = parent.parent
        return parent.value if parent else None
