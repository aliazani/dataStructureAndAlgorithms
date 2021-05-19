package NonLinear.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie2 {

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;

        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        var current = root;

        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public boolean recursiveContains(String word) {
        if (word == null)
            return false;
        return recursiveContains(word, root, 0);
    }

    private boolean recursiveContains(String word, Node root, int index) {
        if (index == word.length())
            return root.isEndOfWord;

        if (root == null)
            return false;

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return false;
        return recursiveContains(word, child, index + 1);
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    private void preOrderTraverse(Node root) {
        System.out.println(root.value);

        for (var child : root.getChildren())
            preOrderTraverse(child);
    }

    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node root) {
        for (var child : root.getChildren())
            postOrderTraverse(child);

        System.out.println(root.value);
    }

    public void remove(String word) {
        if (word == null)
            return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);
        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public String longestCommonPrefix(String[] words) {
        if (words == null)
            return "";

        var trie = new Trie2();
        for (var word : words)
            trie.insert(word);

        var prefix = new StringBuilder();
        var maxChars = getShortest(words).length();
        var current = trie.root;

        while (prefix.length() < maxChars) {
            var children = current.getChildren();
            if (children.length != 1)
                break;
            current = children[0];
            prefix.append(current.value);
        }
        return prefix.toString();
    }

    private String getShortest(String[] words) {
        if (words == null || words.length == 0)
            return "";

        var shortest = words[0];
        for (int i = 1; i < words.length; i++)
            if (words[i].length() < shortest.length())
                shortest = words[i];

        return shortest;
    }

    public int countWord() {
        return countWord(root);
    }

    private int countWord(Node root) {
        var total = 0;

        if (root.isEndOfWord)
            total++;

        for (var child : root.getChildren())
            total += countWord(child);
        return total;
    }

    public List<String> findWords(String prefix) {
        if (prefix == null)
            return null;

        var lastNode = findLastNodeOf(prefix);
        List<String> words = new ArrayList<>();
        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if (root == null)
            return;

        if (root.isEndOfWord)
            words.add(prefix);
        for (var child : root.getChildren())
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNodeOf(String prefix) {
        var current = root;
        for (var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);

            if (child == null)
                return null;

            current = child;
        }
        return current;
    }
}