package NonLinear.Heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {
    MaxHeap<Integer> maxHeap;

    @Before
    public void setUp() {
        maxHeap = new MaxHeap<Integer>(10);
    }

    @Test
    public void insertion() {
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(4);
        maxHeap.insert(40);
        Assert.assertEquals(maxHeap.toString(), "[40, 10, 4, 5, null, null, null, null, null, null]");
    }

    @Test
    public void remove() {
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(12);
        maxHeap.insert(9);
        maxHeap.insert(4);
        maxHeap.insert(1);
        maxHeap.insert(24);
        maxHeap.remove();
        Assert.assertEquals(maxHeap.toString(), "[15, 12, 9, 8, 10, 3, 4, 1, null, null]");
    }

    @Test
    public void isMaxheap() {
        Assert.assertFalse(maxHeap.isMaxHeap(new Integer[]{21, 10, 25}));
        Assert.assertTrue(maxHeap.isMaxHeap(new Integer[]{50, 25, 15, 10, 12, 7, 8}));
    }
}
