package NonLinear.BinaryTree.AVLTree;

import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {
    private AVLTree<Integer> tree;

    @Before
    public void setOptions() {
        tree = new AVLTree<>();
    }

    @Test
    public void insertRootItem() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(12);
        System.out.println(tree);
    }

}
