import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeAVL {
    private Node root;

    private int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    private int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return balance(node, key);
    }

    private Node balance(Node node, int key) {
        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key)
            return rotateRight(node);
        if (balance < -1 && key > node.right.key)
            return rotateLeft(node);
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(String caminho) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(caminho));

        while(sc.hasNext()){
            root = insert(root, sc.nextInt());
        }
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(Node node, int key) {
        if (node == null)
            return false;
        if (key == node.key)
            return true;
        return key < node.key ? search(node.left, key) : search(node.right, key);
    }

    public void deleteByIndex(int index) {
        List<Integer> orderedList = toListInOrder();
        if (index >= 0 && index < orderedList.size()) {
            int keyToDelete = orderedList.get(index);
            delete(keyToDelete);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public List<Integer> toListInOrder() {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(Node node, List<Integer> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.key);
            inOrder(node.right, list);
        }
    }

    private Node delete(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;
                root = (temp == null) ? null : temp;
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }
        if (root == null)
            return root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return balance(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }


    public void clear() {
        root = null;
    }

    public int MinNode() {
        if (root == null) throw new IllegalStateException("Árvore vazia.");
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    public int MaxNode() {
        if (root == null) throw new IllegalStateException("Árvore vazia.");
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.key;
    }

    public Integer sucessorByIndex(int index) {
        List<Integer> list = toListInOrder();
        if (index >= 0 && index < list.size() - 1) {
            return list.get(index + 1);
        }
        System.out.println("Índice inválido ou não há sucessor.");
        return null;
    }

    public Integer predecessorByIndex(int index) {
        List<Integer> list = toListInOrder();
        if (index > 0 && index < list.size()) {
            return list.get(index - 1);
        }
        System.out.println("Índice inválido ou não há predecessor.");
        return null;
    }

}
