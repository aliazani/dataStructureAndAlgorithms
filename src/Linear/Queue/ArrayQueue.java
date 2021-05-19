package Linear.Queue;

import java.util.ArrayList;

public class ArrayQueue<T> {
    private ArrayList<T> arrayList = new ArrayList<>();
    private int size;

    public void enqueue(T item) {
        arrayList.add(item);
        size++;
    }

    public T dequeue() {
        var rear = arrayList.remove(0);
        size--;
        return rear;
    }

    public T peek() {
        return arrayList.get(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }
}
