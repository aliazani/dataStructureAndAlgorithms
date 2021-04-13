package NonLinear.AVLTree;

public class AVLTree<T extends Comparable<T>> {
    private static class AVLNode<T> {
        private int height;
        private final T value;
        private AVLNode<T> rightChild;
        private AVLNode<T> leftChild;

        public AVLNode(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value=" + this.value;
        }
    }

    private AVLNode<T> root;

    public void insert(T item) {
        root = insert(root, item);
    }

    private AVLNode<T> insert(AVLNode<T> root, T item) {
        if (root == null)
            return new AVLNode<>(item);
        if (item.compareTo(root.value) > 0)
            root.rightChild = insert(root.rightChild, item);
        else if (item.compareTo(root.value) < 0)
            root.leftChild = insert(root.leftChild, item);

        setHeight(root);
        return balance(root);
    }

    private void setHeight(AVLNode<T> node) {
        node.height = Math.max(height(node.rightChild), height(node.leftChild)) + 1;
    }

    private AVLNode<T> balance(AVLNode<T> root) {
        if (isRightHeavy(root)) {
            if (balancedFactor(root.rightChild) > 0)
                root.rightChild = rightRotation(root.rightChild);
            return leftRotation(root);
        } else if (isLeftHeavy(root)) {
            if (balancedFactor(root.leftChild) < 0)
                root.leftChild = leftRotation(root.leftChild);
            return rightRotation(root);
        }
        return root;
    }

    private boolean isRightHeavy(AVLNode<T> node) {
        return balancedFactor(node) < -1;
    }

    private boolean isLeftHeavy(AVLNode<T> node) {
        return balancedFactor(node) > 1;
    }

    private int balancedFactor(AVLNode<T> node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode<T> node) {
        return (node == null) ? -1 : node.height;
    }

    private AVLNode<T> leftRotation(AVLNode<T> root) {
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode<T> rightRotation(AVLNode<T> root) {
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }
}
