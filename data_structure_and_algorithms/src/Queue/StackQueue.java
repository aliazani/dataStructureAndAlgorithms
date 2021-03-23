package Queue;

import java.util.Stack;

public class StackQueue<T> {
    private final Stack<T> reversedStack = new Stack<>();
    // 2 stack
    private Stack<T> stack = new Stack<>();
    private int count;

    // [1, 2, 3, 4]
    // [4, 3, 2, 1]
    public void enqueue(T item) {
        stack.push(item);
        count++;
    }

    public T dequeue() {
        reverseTheStack();
        var rear = reversedStack.pop();
        count--;
        return rear;
    }

    public T peek() {
        reverseTheStack();

        var rear = reversedStack.peek();
        return rear;
    }

    private void reverseTheStack() {
        if (reversedStack.isEmpty())
            while (!stack.isEmpty())
                reversedStack.push(stack.pop());
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        if (stack.toString().equals("[]"))
            return "reversed: " + reversedStack.toString();
        else if (!stack.toString().equals("[]") && !reversedStack.toString().equals("[]"))
            return "reversed: " + stack.toString().replace("]", ", ")
                    + reversedStack.toString().replace("[", "");
        else
            return stack.toString();
    }
}