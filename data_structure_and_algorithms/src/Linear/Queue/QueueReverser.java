package Linear.Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser<T> {
    public void reverse(int n, Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        Queue<T> remainingItems = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
            stack.push(queue.remove());

        for (int i = 0; i <= queue.size(); i++)
            remainingItems.add(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        while (!remainingItems.isEmpty())
            queue.add(remainingItems.remove());


    }
}
