package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues<T> {
    private Queue<T> queue1 = new ArrayDeque<>();
    private Queue<T> queue2 = new ArrayDeque<>();
    private Queue<T> temp = new ArrayDeque<>();

    private int count;

    public void push(T item) {
        queue1.add(item);
        count++;
    }

    public T pop() {
        RemoveAllItemsFromQueue1ToRemainTheLastItem();
        swapQueue1WithQueue2();
        count--;
        return queue2.remove();
    }

    public T peek() {
        RemoveAllItemsFromQueue1ToRemainTheLastItem();
        swapQueue1WithQueue2();
        count--;
        return queue2.peek();
    }

    private void RemoveAllItemsFromQueue1ToRemainTheLastItem() {
        while (queue1.size() > 1)
            queue2.add(queue1.remove());
    }

    private void swapQueue1WithQueue2() {
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        if (queue1.toString().equals("[]"))
            return "reversed: " + queue2.toString();
        else if (!queue1.toString().equals("[]") && !queue2.toString().equals("[]"))
            return "reversed: " + queue1.toString().replace("]", ", ")
                    + queue2.toString().replace("[", "");
        else
            return queue1.toString();
    }
}
