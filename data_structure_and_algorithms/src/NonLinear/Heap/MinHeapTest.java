package NonLinear.Heap;

import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {
    private MinHeap<Integer, String> minHeap;

    @Before
    public void setUp() {
        minHeap = new MinHeap<>(10);
    }

    @Test
    public void insertion() {
        minHeap.add(15, "ali");
        minHeap.add(4, "mohammad");
        minHeap.add(9, "reza");
        minHeap.add(12, "ahmad");
        minHeap.add(25, "saber");
        minHeap.add(2, "majid");
        minHeap.add(1, "mehdi");
        minHeap.add(28, "mahmood");
        minHeap.add(32, "john");
        minHeap.add(30, "mosh");
        System.out.println("pass");
    }

    @Test
    public void remove() {
        minHeap.add(13, "ali");
        minHeap.add(5, "mohammad");
        minHeap.add(12, "reza");
        minHeap.add(10, "ahmad");
        minHeap.add(23, "saber");
        minHeap.add(28, "majid");
        minHeap.add(2, "mehdi");
        System.out.println(minHeap);
        minHeap.remove();
        System.out.println(minHeap);
        minHeap.remove();
        System.out.println(minHeap);
    }
}
