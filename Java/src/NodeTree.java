public class NodeTree {
    int value;
    NodeTree left;
    NodeTree right;
    NodeTree parent;

    NodeTree(int v){
        this.value = v;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
