package NonLinear.Heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeapTest {
    Heap<Integer> heap;

    @Before
    public void setUp() {
        heap = new Heap<Integer>(10);
    }

    @Test
    public void insertion() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(4);
        heap.insert(40);
        Assert.assertEquals(heap.toString(), "[40, 10, 4, 5, null, null, null, null, null, null]");
    }

    @Test
    public void remove() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        heap.remove();
        heap.remove();
        heap.remove();
        Assert.assertEquals(heap.toString(), "[5, 4, null, null, null, null, null, null, null, null]");
    }

    @Test
    public void isMaxheap() {
        Assert.assertFalse(heap.isMaxHeap(new Integer[]{21, 10, 25}));
        Assert.assertTrue(heap.isMaxHeap(new Integer[]{50, 25, 15, 10, 12, 7, 8}));
    }
}
