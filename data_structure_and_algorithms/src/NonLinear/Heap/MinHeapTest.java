package NonLinear.Heap;

import org.junit.Assert;
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
        Assert.assertEquals(minHeap.toString()
                , "[1 = mehdi, 12 = ahmad, 2 = majid, 15 = ali," +
                        " 25 = saber, 9 = reza, 4 = mohammad, 28 = mahmood, 32 = john, 30 = mosh]");
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
        minHeap.remove();
        minHeap.remove();
        Assert.assertEquals(minHeap.toString(),
                "[10 = ahmad, 13 = ali, 12 = reza, 28 = majid, 23 = saber, null, null, null, null, null]");
    }
}
