package Arrays;

import java.util.Arrays;

public class Array<T extends Comparable<T>> {
    private T[] items;
    private Array<T> arrayWithNewLength;
    private int count;

    public Array(int length) {
        items = (T[]) new Comparable[length];
    }

    public void insert(T item) {
        insertAt(item, count);
    }

    public void insertAt(T item, int index) {
        createNewArray();
        insertItemAtVariousPlacesOfArray(item, index);
        replaceOldArrayWithResizedOne();
        count++;
    }

    private void createNewArray() {
        if (isArrayFull()) {
            arrayWithNewLength = new Array<T>(items.length + 1);
        } else {
            arrayWithNewLength = new Array<T>(items.length);
        }
    }

    private boolean isArrayFull() {
        return count >= items.length;
    }

    private void insertItemAtVariousPlacesOfArray(T item, int index) {
        if (isInsertionAtTheEndOfArray(index)) {
            insertAtTheEndOfArray(item, index);
        } else if (isInsertionAtTheFirstOfArray(index)) {
            insertAtTheFirstOfArray(item, index);
        } else {
            insertInTheMiddleOfArray(item, index);
        }
    }

    private void insertAtTheEndOfArray(T item, int index) {
        copyItemsBeforeInsertNewItemAtIndex(index);
        arrayWithNewLength.items[index] = item;
    }

    private void insertAtTheFirstOfArray(T item, int index) {
        arrayWithNewLength.items[index] = item;
        shiftOneItemToRight(0);
    }

    private void insertInTheMiddleOfArray(T item, int index) {
        copyItemsBeforeInsertNewItemAtIndex(index);
        arrayWithNewLength.items[index] = item;
        shiftOneItemToRight(index);
    }

    private boolean isInsertionAtTheEndOfArray(int index) {
        return index == arrayWithNewLength.items.length - 1;
    }

    private void copyItemsBeforeInsertNewItemAtIndex(int index) {
        for (int i = 0; i < index; i++)
            if (isNotNull(items[i]))
                arrayWithNewLength.items[i] = items[i];
    }

    private boolean isInsertionAtTheFirstOfArray(int index) {
        return index == 0;
    }


    private void shiftOneItemToRight(int start) {
        for (int i = start; i < items.length; i++)
            if (isNotNull(items[i]))
                arrayWithNewLength.items[i + 1] = items[i];
    }

    public void removeAt(int index) {
        items[index] = null;
        arrayWithNewLength = new Array<T>(--count);
        copyItemsToResizedArray();
        replaceOldArrayWithResizedOne();
    }

    private void copyItemsToResizedArray() {
        for (T item : items)
            if (isNotNull(item))
                arrayWithNewLength.insert(item);
    }

    private boolean isNotNull(T item) {
        return item != null;
    }

    private void replaceOldArrayWithResizedOne() {
        items = arrayWithNewLength.items;
    }

    public int indexOf(T item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    public Array<T> reverse() {
        var reversedArray = new Array<T>(items.length);

        for (int i = items.length - 1; i >= 0; i--)
            reversedArray.insert(items[i]);

        return reversedArray;
    }

    public T max() {
        T maximumValue = items[0];
        for (int i = 1; i < items.length; i++)
            if (maximumValue.compareTo(items[i]) < 0)
                maximumValue = items[i];

        return maximumValue;
    }

    public Array<T> intersect(Array<T> other) {
        var lengthOfFirstArray = items.length;
        var intersectedArray = new Array<T>(lengthOfFirstArray);

        for (T item : items)
            for (int j = 0; j < other.items.length; j++)
                if (item == other.items[j])
                    intersectedArray.insert(item);

        return intersectedArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
