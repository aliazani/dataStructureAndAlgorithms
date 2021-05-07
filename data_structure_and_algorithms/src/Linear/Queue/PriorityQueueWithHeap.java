package Linear.Queue;

import NonLinear.Heap.Heap;

public class PriorityQueueWithHeap<T extends Comparable<T>> {
    private final Heap<T> heap;

    public PriorityQueueWithHeap(int size) {
        heap = new Heap<>(size);
    }

    public void enqueue(T item) {
        heap.insert(item);
    }

    public T dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
