package NonLinear.Trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void findWords() {
        trie2.insert("smart");
        trie2.insert("car");
        trie2.insert("card");
        trie2.insert("care");
        trie2.insert("careful");
        trie2.insert("carefully");

        Assert.assertArrayEquals(trie2.findWords("car").toArray(),
                List.of("car", "card", "care", "careful", "carefully").toArray());
    }

    @Test
    public void recursiveContains() {
        trie2.insert("car");
        trie2.insert("card");
        Assert.assertTrue(trie2.recursiveContains("car"));
        Assert.assertFalse(trie2.recursiveContains("cabin"));

    }
}