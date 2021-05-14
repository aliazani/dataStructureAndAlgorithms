package NonLinear.Trie;

import org.junit.Before;
import org.junit.Test;

public class TrieTest {
    private Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();
    }

    @Test
    public void insertTest() {
        trie.insert("cat");
        trie.insert("can");
        System.out.println(trie);
    }
}