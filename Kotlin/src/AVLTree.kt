class Node(var key: Int){
    var height: Int = 1
    var left: Node? = null
    var right: Node? = null

}

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

    
}