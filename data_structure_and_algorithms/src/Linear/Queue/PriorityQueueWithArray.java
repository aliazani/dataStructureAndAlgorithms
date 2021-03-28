package Linear.Queue;

import java.util.ArrayList;

public class PriorityQueueWithArray<T extends Comparable<T>> {
    private ArrayList<T> arrayList = new ArrayList<>();
    private int count;

    public void add(T item) {
        arrayList.add(item);
        int i = shiftItemsToInsert(item);
        arrayList.set(i, item);
        count++;
    }

    private int shiftItemsToInsert(T item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (item.compareTo(arrayList.get(i)) < 0)
                arrayList.set(i + 1, arrayList.get(i));
            else
                break;
        }
        return i + 1;
    }


    public T removeAtFirst() {
        var firstItem = arrayList.get(0);
        arrayList.remove(0);
        count--;
        return firstItem;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }
}
