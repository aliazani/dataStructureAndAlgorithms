package Linear.HashTables;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private final Entry<K, V>[] entries;
    private final int size;
    private int count;

    public MyHashMap(int size) {
        entries = new Entry[size];
        this.size = size;
    }

    public void put(K key, V value) {
        var i = getIndexOf(key);

        if (isKeyExists(i))
            entries[i].value = value;
        else {
            if (isFull())
                throw new IllegalStateException();

            var index = hash(key);
            while (entries[index] != null)
                index = (index + 1) % size;

            entries[index] = new Entry<>(key, value);
            count++;
        }
    }

    public V get(K key) {
        var index = getIndexOf(key);
        return (entries[index] == null) ? null : entries[index].value;
    }

    public void remove(K key) {
        var index = getIndexOf(key);
        entries[index] = null;
        count--;
    }

    public int size() {
        return count;
    }

    private boolean isFull() {
        return count == size;
    }

    private int hash(K key) {
        return key.hashCode() % size;
    }

    private boolean isKeyExists(int i) {
        return i != -1;
    }

    private int getIndexOf(K key) {
        for (int i = 0; i < entries.length; i++)
            if (entries[i] != null && entries[i].key == key)
                return i;

        return -1;
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
