package NonLinear.Heap;

import java.util.Arrays;

public class HeapifiyDemo {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 1, 2};

        System.out.println(MaxHeap.kthLargestNode(numbers, 1));

        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}