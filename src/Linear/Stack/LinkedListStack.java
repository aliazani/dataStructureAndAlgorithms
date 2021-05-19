package Linear.Stack;

import java.util.LinkedList;

public class LinkedListStack<E> {

    private final LinkedList<E> linkedList;
    private int count;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    public void push(E item) {
        linkedList.add(item);
        count++;
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    public E pop() {
        var top = linkedList.removeLast();
        count--;
        return top;
    }

    public E peek() {
        return linkedList.getLast();
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
