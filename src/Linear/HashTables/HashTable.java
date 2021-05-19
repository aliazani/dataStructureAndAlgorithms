package Linear.HashTables;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable<K, V> {
    private final LinkedList<Entry<K, V>>[] entries;
    private int count;

    public HashTable(int size) {
        entries = new LinkedList[size];
    }

    public void put(K key, V value) {
        count++;
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        var bucket = getOrCreateBucket(key);
        bucket.addLast(new Entry<>(key, value));
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % entries.length;
    }

    public V get(K key) {
        var entry = getEntry(key);

        return (entry == null) ? null : entry.value;
    }

    public void remove(K key) {
        var entry = getEntry(key);

        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove();
        count--;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private Entry<K, V> getEntry(K key) {
        var bucket = getBucket(key);

        if (bucket != null)
            for (var entry : bucket)
                if (entry.key == key)
                    return entry;

        return null;
    }

    private LinkedList<Entry<K, V>> getBucket(K key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry<K, V>> getOrCreateBucket(K key) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        return entries[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
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
