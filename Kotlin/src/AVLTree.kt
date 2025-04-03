import tree.Node
class AVLTree{

    private fun height(node: Node?): Int{
        return node?.height ?: 0
    } 

    private fun upHeight(node: Node){
        node.height = 1 + maxOf(height(node.left), height(node.right))
    }

    private fun balFactor(node: Node?): Int{
        return height(node.left) - height(node.right)
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
        if (root == null) return root
        if (key < root.key) {
            root.left = delete(root.left, key)
        } else if (key > root.key) {
            root.right = delete(root.right, key)
        } else {
            if (root.left == null || root.right == null) {
                var temp: Node? = null
                temp = root.left ?: root.right
                if (temp == null) {
                    temp = root
                    root = null
                } else {
                    root = temp
                }
            } else {
                val temp = minVNode(root.right!!)
                root.key = temp.key
                root.right = delete(root.right, temp.key)
            }
        }
        if (root == null) return root
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

    private fun minVNode(node: Node): Node {
        var current = node
        while (current.left != null) current = current.left!!
        return current
    }
    
    fun preOrder(root: Node?) {
        if (root != null) {
            println(root.key)
            preOrder(root.left)
            preOrder(root.right)
        }
    }
}