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

    @Override
    public String toString() {
        return root.toString();

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
