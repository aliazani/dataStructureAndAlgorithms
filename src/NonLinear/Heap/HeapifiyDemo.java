package NonLinear.Heap;

import java.util.Arrays;

public class HeapifiyDemo {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 1, 2};

        System.out.println(Heapify.kthLargestNode(numbers, 1));

        Heapify.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}