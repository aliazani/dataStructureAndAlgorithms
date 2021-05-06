package NonLinear.Heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = {10, 16, 3, 14, 12, 5};
        var heap = new Heap<Integer>(6);

        for (var number : numbers)
            heap.insert(number);

//        for (int i = 0; i < numbers.length; i++)
//            numbers[i] = heap.remove();

        for (int i = numbers.length - 1; i >= 0; i--)
            numbers[i] = heap.remove();

        System.out.println(Arrays.toString(numbers));
    }
}
