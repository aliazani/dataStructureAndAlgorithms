package NonLinear.Trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {
    private Trie trie;
    private Trie2 trie2;

    @Before
    public void setUp() {
        trie = new Trie();
        trie2 = new Trie2();
    }

    @Test
    public void insertTestForArray() {
        trie.insert("cat");
        trie.insert("can");
        System.out.println(trie);
    }

    @Test
    public void insertTestForHashMap() {
        trie2.insert("cat");
        trie2.insert("can");
        System.out.println(trie2);
    }

    @Test
    public void lookup() {
        trie2.insert("canada");
        trie2.insert("cat");
        Assert.assertTrue(trie2.contains("canada"));
        Assert.assertFalse(trie2.contains("can"));
        Assert.assertTrue(trie2.contains("cat"));
    }

    @Test
    public void preOrderTraverse() {
        trie2.insert("can");
        trie2.insert("cat");
        trie2.insert("car");
        trie2.insert("canada");
        trie2.preOrderTraverse();
    }

    @Test
    public void postOrderTraverse() {
        trie2.insert("can");
        trie2.postOrderTraverse();
    }

    @Test
    public void delete() {
        trie2.insert("can");
        trie2.insert("canada");
        trie2.remove("canada");
        Assert.assertFalse(trie2.contains("canada"));
        Assert.assertTrue(trie2.contains("can"));
    }
}