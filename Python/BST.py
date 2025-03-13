class Node:
    def __init__(self, value):
        self.value = value
        self.right = None
        self.left = None
        self.parent = None

class BST:

    def __init__(self):
        self.root = None
        self._size = 0

    def __len__(self):
        return self._size

    def is_empty(self):
        return self.root is None

    def add(self, value):
        node = Node(value)
        if self.is_empty():
            self.root = node
        else:
            self.rec_add(self.root, node)
        self._size += 1

    def rec_add(self, current_node, add_node):
        if add_node.value < current_node.value:
            if current_node.left is None:
                current_node.left = add_node
                add_node.parent = current_node
                return
            self.rec_add(current_node.left, add_node)

        else:
            if current_node.right is None:
                current_node.right = add_node
                add_node.parent = current_node
                return

            self.rec_add(current_node.right, add_node)