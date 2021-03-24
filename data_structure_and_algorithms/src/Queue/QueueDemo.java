package Queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class QueueDemo {
    // ArrayQueue (ArrayDeque) enqueue, dequeue, peek , isFull, isEmpty => FIFO
    // Front, Rear => pointers
    // LinkedListQueue
    // StackQueue
    public static void main(String[] args) {
        Queue<Float> queue = new ArrayDeque<>();
        queue.add(1F);
        queue.add(2F);
        queue.add(3F);
        System.out.println(queue);
        reverse(queue);
        System.out.println(queue);
        var front = queue.remove();
        System.out.println(front);
        System.out.println(queue);
        System.out.println("arrayQueue:");
        arrayQueueShow();
        System.out.println("stackQueue:");
        stackQueueShow();
        showPriorityQueue();
        showMyPriorityQueue();
    }

    public static <E> void reverse(Queue<E> queue) {
        Stack<E> stack = new Stack<>();

        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static void arrayQueueShow() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.isEmpty());
    }

    public static void stackQueueShow() {
        StackQueue<Integer> stackQueue = new StackQueue<>();
        stackQueue.enqueue(10);
        stackQueue.enqueue(20);
        stackQueue.enqueue(30);
        stackQueue.enqueue(40);
        System.out.println(stackQueue);

        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue);

        stackQueue.enqueue(50);
        System.out.println(stackQueue);

        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue);

        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue);

        System.out.println(stackQueue.dequeue());
        stackQueue.enqueue(60);
        stackQueue.enqueue(70);
        System.out.println(stackQueue.dequeue());
        System.out.println(stackQueue);

    }

    public static void showPriorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(2);
        priorityQueue.add(6);
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());
    }

    public static void showMyPriorityQueue(){
        PriorityQueueWithArray<Integer> priorityQueue = new PriorityQueueWithArray<>();
        priorityQueue.add(0);
        priorityQueue.add(10);
        priorityQueue.add(8);
        priorityQueue.add(2);
        priorityQueue.add(11);
        priorityQueue.add(1);
        System.out.println("myPriorityQueue:");
        System.out.println(priorityQueue);
    }
}
