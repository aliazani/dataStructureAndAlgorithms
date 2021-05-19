package NonLinear.Heap;

import java.text.MessageFormat;
import java.util.Arrays;

public class MinHeap<T extends Comparable<T>, E extends Comparable<E>> {
    private class Node<T, E> {
        T key;
        E value;

        public Node(T key, E value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return MessageFormat.format("{0} = {1}", key, value);
        }
    }

    private final Node<T, E>[] items;
    private int count;

    public MinHeap(int size) {
        items = (Node<T, E>[]) new Node[size];
    }

    public void add(T key, E value) {
        if (isFull())
            throw new IllegalStateException("The heap is full!!");
        items[count++] = new Node<>(key, value);
        bubbleUp();
    }

    public boolean isFull() {
        return (items.length == count);
    }

    private void bubbleUp() {
        var index = count - 1;

        while (index > 0 &&
                items[index].key.compareTo(items[getParentIndex(index)].key) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public Node<T, E> remove() {
        if (isEmpty())
            throw new IllegalStateException("Heap is Empty!!!");

        var root = items[0];
        items[0] = items[count - 1];
        items[count - 1] = null;
        count--;

        bubbleDown();

        return root;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void bubbleDown() {
        var index = 0;

        while (index < count && !isValidParent(index)) {
            var smallerIndex = getLeftChildIndex(index);
            swap(index, getSmallerChild(index));
            index = smallerIndex;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        if (!hasRightChild(index))
            return items[index].key
                    .compareTo(items[getLeftChildIndex(index)].key) <= 0;
        else
            return items[index].key
                    .compareTo(items[getLeftChildIndex(index)].key) <= 0
                    && items[index].key
                    .compareTo(items[getRightChildIndex(index)].key) <= 0;
    }

    private int getSmallerChild(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return getLeftChildIndex(index);
        else
            return (items[getLeftChildIndex(index)].key
                    .compareTo(items[getRightChildIndex(index)].key) < 0)
                    ? getLeftChildIndex(index)
                    : getRightChildIndex(index);
    }


    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < count;
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < count;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    public Node<T, E> minimum() {
        if (isEmpty())
            throw new IllegalStateException("Heap is Empty!!");
        return items[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
