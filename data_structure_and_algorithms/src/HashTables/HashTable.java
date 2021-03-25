package HashTables;

import java.util.LinkedList;

public class HashTable<K, V> {
    private int count;
    private int size;
    private LinkedList<Entry<K, V>>[] entries;

    public HashTable(int size) {
        this.size = size;
        entries = new LinkedList[size];
    }
    // collision :chaining
    // Entry -> wrap key and value
    // [LL<Entry>, LL, LL, LL, LL]

    public void put(K key, V value) {
        count++;
    }

    public V get(K key) {
        return null;
    }

    public void remove(K key) {
        count--;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return entries.toString();
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
