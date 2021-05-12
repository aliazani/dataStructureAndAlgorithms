package NonLinear.Heap;

public class Heapify {
    public static void heapify(int[] array) {
        for (int i = getIndexOfLastParent(array); i >= 0; i--)
            heapify(array, i);
    }

    private static int getIndexOfLastParent(int[] array) {
        return (array.length / 2) - 1;
    }

    private static void heapify(int[] array, int index) {
        int largerIndex = index;

        var leftIndex = (index * 2) + 1;
        if (leftIndex < array.length && array[largerIndex] < array[leftIndex])
            largerIndex = leftIndex;

        var rightIndex = (index * 2) + 2;
        if (rightIndex < array.length && array[largerIndex] < array[rightIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int kthLargestNode(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalStateException();

        Heap<Integer> heap = new Heap<>(array.length);
        for (var item : array)
            heap.insert(item);
        
        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }
}