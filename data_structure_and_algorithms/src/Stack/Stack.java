package Stack;

import java.util.ArrayList;

public class Stack<T extends Comparable<T>> {
    private int count;
    private ArrayList<T> array;

    public Stack() {
        array = new ArrayList<>();
    }

    public void push(T item) {
        array.add(item);
        count++;
    }

    public T pop() {
        var top = array.get(count - 1);
        array.remove(--count);
        return top;
    }

    public T peek() {
        return array.get(count - 1);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public T minimum() {
        var minValue = array.get(0);
        for (var each : array)
            if (each.compareTo(minValue) < 0)
                minValue = each;
        return minValue;
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
