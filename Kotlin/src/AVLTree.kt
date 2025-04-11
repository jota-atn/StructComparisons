package estruturas
import tree.Node

class AVLTree {

    private fun height(node: Node?): Int {
        return node?.height ?: 0
    }

    private fun upHeight(node: Node) {
        node.height = 1 + maxOf(height(node.left), height(node.right))
    }

    private fun balFactor(node: Node?): Int {
        return height(node?.left) - height(node?.right)
    }

    private fun leftRot(a: Node): Node {
        val b = a.right!!
        val c = b.left
        b.left = a
        a.right = c
        upHeight(a)
        upHeight(b)
        return b
    }

    private fun rightRot(y: Node): Node {
        val x = y.left!!
        val T2 = x.right
        x.right = y
        y.left = T2
        upHeight(y)
        upHeight(x)
        return x
    }

    fun insert(root: Node?, key: Int): Node {
        if (root == null) return Node(key)
        if (key < root.key) root.left = insert(root.left, key)
        else if (key > root.key) root.right = insert(root.right, key)
        else return root

        upHeight(root)
        val balance = balFactor(root)

        if (balance > 1) {
            if (key < root.left!!.key) {
                return rightRot(root)
            } else {
                root.left = leftRot(root.left!!)
                return rightRot(root)
            }
        }

        if (balance < -1) {
            if (key > root.right!!.key) {
                return leftRot(root)
            } else {
                root.right = rightRot(root.right!!)
                return leftRot(root)
            }
        }
        return root
    }

    fun delete(root: Node?, key: Int): Node? {
        if (root == null) return null

        if (key < root.key) {
            root.left = delete(root.left, key)
        } else if (key > root.key) {
            root.right = delete(root.right, key)
        } else {
            if (root.left == null || root.right == null) {
                return root.left ?: root.right
            } else {
                val temp = minVNode(root.right!!)
                root.key = temp.key
                root.right = delete(root.right, temp.key)
            }
        }

        upHeight(root)
        val balance = balFactor(root)

        if (balance > 1) {
            if (balFactor(root.left) >= 0) {
                return rightRot(root)
            } else {
                root.left = leftRot(root.left!!)
                return rightRot(root)
            }
        }

        if (balance < -1) {
            if (balFactor(root.right) <= 0) {
                return leftRot(root)
            } else {
                root.right = rightRot(root.right!!)
                return leftRot(root)
            }
        }

        return root
    }

    fun search(root: Node?, key: Int): Node? {
        var current = root
        while (current != null) {
            current = when {
                key < current.key -> current.left
                key > current.key -> current.right
                else -> return current
            }
        }
        return null
    }

    fun sucessor(root: Node?, key: Int): Node? {
        var current = root
        var successor: Node? = null
        while (current != null) {
            if (key < current.key) {
                successor = current
                current = current.left
            } else {
                current = current.right
            }
        }
        return successor
    }

    fun predecessor(root: Node?, key: Int): Node? {
        var current = root
        var predecessor: Node? = null
        while (current != null) {
            if (key > current.key) {
                predecessor = current
                current = current.right
            } else {
                current = current.left
            }
        }
        return predecessor
    }

    fun min(root: Node?): Node? {
        var current = root
        while (current?.left != null) {
            current = current.left
        }
        return current
    }

    fun max(root: Node?): Node? {
        var current = root
        while (current?.right != null) {
            current = current.right
        }
        return current
    }

    private fun minVNode(node: Node): Node {
        var current = node
        while (current.left != null) current = current.left!!
        return current
    }
}
