package NonLinear.BinaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree<Integer> tree1 = new BinaryTree<>(10);
        tree1.insert(20);
        tree1.insert(12);
        tree1.insert(30);
        tree1.insert(4);
        tree1.insert(8);
        tree1.insert(3);
        var res = tree1.find(10);
        System.out.println(res);
        var res2 = tree1.find(23);
        System.out.println(res2);
        System.out.println(tree1);
        System.out.println("Post Order:");
        tree1.traversePostOrder();
        System.out.println("Pre Order:");
        tree1.traversePreOrder();
        System.out.println("In order:");
        tree1.traverseInOrder();
        System.out.println("height: " + tree1.height());
        System.out.println("Minimum: " + tree1.minimum());

        BinaryTree<Integer> tree2 = new BinaryTree<>(10);
        tree2.insert(20);
        tree2.insert(12);
        tree2.insert(30);
        tree2.insert(4);
        tree2.insert(8);
        tree2.insert(3);
        System.out.println("equals: " + tree1.equals(tree2));

        System.out.println("Binary Tree: " + tree1.isBinarySearchTree(Integer.MIN_VALUE, Integer.MAX_VALUE));
        tree1.swapRoot();
        System.out.println("Binary Tree: " + tree1.isBinarySearchTree(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
