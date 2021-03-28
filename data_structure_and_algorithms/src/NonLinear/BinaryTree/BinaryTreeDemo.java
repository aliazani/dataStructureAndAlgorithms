package NonLinear.BinaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args){
        BinaryTree<Integer> tree = new BinaryTree<>(10);
        tree.insert(20);
        tree.insert(3);
        tree.insert(12);
        tree.insert(8);
        var res = tree.find(10);
        System.out.println(res);
        var res2 = tree.find(23);
        System.out.println(res2);
        System.out.println(tree);
    }
}
