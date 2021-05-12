package NonLinear.Heap;

import java.util.Arrays;

public class Heap<T extends Comparable<T>> {
    private final T[] items;
    private int size;

    public Heap(int size) {
        items = (T[]) new Comparable[size];
    }

    public boolean isMaxHeap(T[] array) {
        var index = array.length - 1;

        while (index > 0) {
            if (array[index].compareTo(array[getParentIndex(index)]) > 0)
                return false;
            index = getParentIndex(index);
        }
        return true;
    }

    public void insert(T item) {
        if (isFull())
            throw new IllegalStateException("Heap is full!!");
        items[size++] = item;
        bubbleUp();
    }

    public boolean isFull() {
        return items.length == size;
    }

    private void bubbleUp() {
        var index = size - 1;

        while (index > 0 && items[index].compareTo(items[getParentIndex(index)]) > 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public T remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = items[0];
        items[0] = items[size - 1];
        items[size - 1] = null;
        size--;
        bubbleDown();

        return root;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            swap(index, getLargerChildIndex(index));
            index = getLargerChildIndex(index);
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        else if (!hasRightChild(index))
            return items[index].compareTo(leftChild(index)) >= 0;
        else
            return items[index].compareTo(leftChild(index)) >= 0
                    && items[index].compareTo(rightChild(index)) >= 0;
    }

    private int getLargerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        else if (!hasRightChild(index))
            return getLeftChildIndex(index);
        else
            return (leftChild(index).compareTo(rightChild(index)) > 0)
                    ? getLeftChildIndex(index)
                    : getRightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private T leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private T rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    public T max() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
