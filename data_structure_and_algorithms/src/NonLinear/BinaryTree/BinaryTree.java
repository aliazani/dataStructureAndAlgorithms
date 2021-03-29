package NonLinear.BinaryTree;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree(T root) {
        this.root = new Node<>(root);
    }

    public void insert(T item) {
        var node = new Node<>(item);
        var current = root;
        while (true) {
            if (current.value.compareTo(item) > 0) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(T item) {
        var current = root;

        while (current != null) {
            if (current.value.compareTo(item) > 0)
                current = current.leftChild;
            else if (current.value.compareTo(item) < 0)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBinarySearchTree(T min, T max) {
        return isBinarySearchTree(root, min, max);
    }

    private boolean isBinarySearchTree(Node<T> root, T min, T max) {
        if (isEmpty(root))
            return true;
        if (root.value.compareTo(min) <= 0 || root.value.compareTo(max) >= 0)
            // root - max < 0
            // root - min > 0
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value) &&
                isBinarySearchTree(root.rightChild, root.value, max);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node<T> root) {
        if (isEmpty(root))
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node<T> root) {
        if (isEmpty(root))
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> root) {
        if (isEmpty(root))
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> root) {
        if (isEmpty((Node<T>) root))
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }

    public boolean equals(BinaryTree<T> other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node<T> first, Node<T> second) {
        if (first == null && second == null)
            return true;
        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        return false;
    }

    public T minimum() {
        return minimum(root);
    }

    private T minimum(Node<T> root) {
        if (isLeaf(root))
            return root.value;
        T minValue = null;
        var left = minimum(root.leftChild);
        var right = minimum(root.rightChild);
        minValue = (right.compareTo(left) < 0) ? right : left;
        minValue = root.value.compareTo(minValue) < 0 ? root.value : minValue;
        return minValue;
    }

    private boolean isLeaf(Node<T> root) {
        return root.rightChild == null && root.leftChild == null;
    }

    private boolean isEmpty(Node<T> root) {
        return root == null;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    private class Node<T> {
        private final T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
}
