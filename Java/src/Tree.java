public class Tree{
    NodeTree root;

    public boolean isEmpty(){
        return this.root == null;
    }

    public void recursiveAdd(int element){
        if(isEmpty()) this.root = new NodeTree(element);
        else{
            recursiveAdd(this.root, element);
        }
    }

    private void recursiveAdd(NodeTree node, int element){
        if(element < node.value){
            if(node.left == null){
                NodeTree newNode = new NodeTree(element);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            recursiveAdd(node.left, element);
        }
        else{
            if(node.right == null){
                NodeTree newNode = new NodeTree(element);
                node.right = newNode;
                newNode.parent = node;
                return;
            }
            recursiveAdd(node.right, element);
        }
    }

    public NodeTree recursiveSearch(int element){
        return recursiveSearch(this.root, element);
    }

    private NodeTree recursiveSearch(NodeTree node, int element){
        if(node == null) return null;
        if(element == node.value) return node;
        if(element < node.value) return recursiveSearch(node.left, element);
        else return recursiveSearch(node.right, element);
    }
}

